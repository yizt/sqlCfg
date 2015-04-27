package com.sitech.sqlcfg.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sitech.sqlcfg.domain.TbExecsql;
import com.sitech.sqlcfg.domain.TbParamCfg;
import com.sitech.sqlcfg.domain.TbSqlCfg;
import com.sitech.sqlcfg.util.LongAdapter;
import com.sitech.sqlcfg.util.Plugin;

public abstract class ParsePlugin extends Plugin implements Parse {

	protected HashMap<String, String> inParam;// 传入参数
	protected HashMap<String, String> singleParam;// 单值替换参数
	protected HashMap<String, List<String>> setParam;// 集合替换参数

	/**
	 * 获取传入参数替换键值集合
	 * 
	 * @param dataTime
	 *            数据时间
	 * @param businessParam
	 *            业务参数
	 * @return
	 */
	public HashMap<String, String> getInParam(String dataTime,
			String businessParam) {
		if (null == inParam) {
			inParam = new HashMap<String, String>();
			inParam.put("$datatime", dataTime);
			if (6 == dataTime.length()) {
				inParam.put("$curmon", dataTime);
				inParam.put("$curday", dataTime + "01");
			} else {
				inParam.put("$curmon", dataTime.substring(0, 6));
				inParam.put("$curday", dataTime);
			}
			if (null != businessParam) {
				inParam.put("$businessparam", businessParam);
			}
		}
		return inParam;
	}

	@Override
	public HashMap<String, List<String>> getSetParam(String dataTime,
			String businessParam) {
		// TODO Auto-generated method stub
		if (null == setParam) {
			setParam = new HashMap<String, List<String>>();
			List<TbParamCfg> list = dbDao.selectList("selectSetParam");
			HashMap<String, String> map = getInParam(dataTime, businessParam);// 传入参数键值对
			for (TbParamCfg tbParamCfg : list) {// 逐个集合替换参数处理
				String paramValExpr = tbParamCfg.getParamvalexpr();// 值的表达式
				for (Map.Entry<String, String> entry : map.entrySet()) {// 逐个替换传入参数
					paramValExpr = paramValExpr.replace(entry.getKey(),
							entry.getValue());
				}
				List<String> paramValue = dbDao.selectStringList(tbParamCfg
						.getParamvalexpr());// 通过表达式获取参数的值集合
				setParam.put(tbParamCfg.getParamname(), paramValue);
			}
		}
		return setParam;
	}

	public HashMap<String, String> getSingleParam(String dataTime,
			String businessParam) {
		// TODO Auto-generated method stub
		if (null == singleParam) {
			singleParam = new HashMap<String, String>();
			List<TbParamCfg> list = dbDao.selectList("selectSingleParam");
			HashMap<String, String> map = getInParam(dataTime, businessParam);// 传入参数键值对
			for (TbParamCfg tbParamCfg : list) {// 逐个单值替换参数处理
				String paramValExpr = getConStantValueSql(tbParamCfg
						.getParamvalexpr());// 值的表达式
				for (Map.Entry<String, String> entry : map.entrySet()) {// 逐个替换传入参数
					paramValExpr = paramValExpr.replace(entry.getKey(),
							entry.getValue());
				}
				System.out.println("paramValExpr:"+paramValExpr);
				String paramValue = dbDao.selectString(paramValExpr);// 通过表达式获取参数的值
				System.out.println("paramValue:"+paramValue);
				singleParam.put(tbParamCfg.getParamname(), paramValue);
			}
		}
		return singleParam;
	}

	/**
	 * 处理单值替换参数，包括传入参数
	 * 
	 * @param list
	 *            配置对象集合
	 * @param dataTime
	 *            数据时间
	 * @param businessParam
	 *            业务参数
	 */
	public void dealSingeParam(List<TbSqlCfg> list, String dataTime,
			String businessParam) {
		String execsql;
		HashMap<String, String> inParam = getInParam(dataTime, businessParam);// 获取传入参数
		HashMap<String, String> singleParam = getSingleParam(dataTime,
				businessParam);// 获取单值替换参数
		for (TbSqlCfg tbSqlCfg : list) {// 逐条配置处理替换
			execsql = tbSqlCfg.getExecsql();
			for (Map.Entry<String, String> entry : inParam.entrySet()) {
				execsql = execsql.replace(entry.getKey(), entry.getValue());
			}
			for (Map.Entry<String, String> entry : singleParam.entrySet()) {
				execsql = execsql.replace(entry.getKey(), entry.getValue()==null?"":entry.getValue());
			}
			tbSqlCfg.setExecsql(execsql);
		}
	}

	/**
	 * 处理set类型替换参数
	 * 
	 * @param result
	 *            保存替换后结果
	 * @param setParams
	 *            set替换参数集合
	 * @param tbSqlCfg
	 *            脚本配置对象
	 * @param dataTime
	 *            数据时间
	 * @param memo
	 *            脚本配置对象备注
	 * @param execsql
	 *            脚本配置对象执行sql
	 * @param seq
	 *            序号
	 */
	public void dealSetParam(List<TbExecsql> result,
			SortedMap<String, List<String>> setParams, TbSqlCfg tbSqlCfg,
			String dataTime, String memo, String execsql, LongAdapter seq) {
		String curMemo;// 当前备注
		String curExecsql;// 当前的sql
		if (setParams.size() >= 1) {
			String curParam = setParams.firstKey();// 当前的参数名
			List<String> curParamValueList = setParams.get(curParam);// 当前参数集合
			if (execsql.contains(curParam)) {// sql包含当前的set替换参数
				for (String curParamValue : curParamValueList) {
					curMemo = memo + ";" + curParam + "=" + curParamValue;
					curExecsql = execsql.replace(curParam, curParamValue);
					if (1 == setParams.size()) {// 到最后一个set替换参数，将memo和sql添加到结果集合
						TbExecsql tbExecsql = new TbExecsql();
						tbExecsql.setDatatime(dataTime);
						tbExecsql.setSeq(seq.getValue());
						tbExecsql.setFuncid(tbSqlCfg.getFuncid());
						tbExecsql.setMemo(curMemo);
						tbExecsql.setExecsql(curExecsql);
						result.add(tbExecsql);
						seq.increase();
					} else {// 没有到最后一个set替换参数,遍历剩余参数
						dealSetParam(result,
								setParams.tailMap(curParam + "\0"), tbSqlCfg,
								dataTime, curMemo, curExecsql, seq);
					}
				}
			} else {// sql包含不当前的set替换参数
				if (1 == setParams.size()) {// 到最后一个set替换参数，将memo和sql添加到结果集合
					TbExecsql tbExecsql = new TbExecsql();
					tbExecsql.setDatatime(dataTime);
					tbExecsql.setSeq(seq.getValue());
					tbExecsql.setFuncid(tbSqlCfg.getFuncid());
					tbExecsql.setMemo(memo);
					tbExecsql.setExecsql(execsql);
					result.add(tbExecsql);
					seq.increase();
				} else {// 没有到最后一个set替换参数,遍历剩余参数
					dealSetParam(result, setParams.tailMap(curParam + "\0"),
							tbSqlCfg, dataTime, memo, execsql, seq);
				}

			}
		} else {// 没有set替换参数，直接增加TbExecsql对象
			TbExecsql tbExecsql = new TbExecsql();
			tbExecsql.setDatatime(dataTime);
			tbExecsql.setSeq(seq.getValue());
			tbExecsql.setFuncid(tbSqlCfg.getFuncid());
			tbExecsql.setMemo(memo);
			tbExecsql.setExecsql(execsql);
			result.add(tbExecsql);
			seq.increase();
		}
	}

	/**
	 * 处理依赖关系的参数替换 应用场景如：用户信息存放在db1,db2两个库crm1,crm2,crm3,crm4个用户下 其中
	 * crm1,crm3在db1,crm2,crm4在db2库中,对于crm[1..4]使用set类型的参数
	 * 对于db[1..2]则使用依赖参数;依赖参数有中括号[]内的表达式决定
	 * 
	 * @param list
	 */
	public void dealDependentParam(List<TbExecsql> list) {
		Pattern pattern = Pattern.compile("\\[[^\\]]*\\]");
		Matcher matcher;
		String dePendentExpr = null;// 依赖参数表达式
		String dePendentValue = null;// 依赖参数的值
		String execSql = null;
		for (TbExecsql tbExecsql : list) {
			execSql = tbExecsql.getExecsql();
			matcher = pattern.matcher(execSql);
			while (matcher.find()
					&& execSql.toLowerCase().indexOf("regexp_like") < 0) {// 逐个参数处理
				dePendentExpr = matcher.group(0);
				dePendentValue = dbDao
						.selectString(getConStantValueSql(dePendentExpr
								.substring(1, dePendentExpr.length() - 1)));
				execSql = execSql.replace(dePendentExpr, dePendentValue);
			}
			tbExecsql.setExecsql(execSql);
		}
	}

	public List<TbExecsql> parse(String funcId, String dataTime, String mode,
			String businessParam) {
		if ("redo".equals(mode) || "debug".equals(mode)) {// 重新生成，先删除原有待执行对象
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("funcId", funcId);
			map.put("datatime", dataTime);
			map.put("businessParam", businessParam);
			dbDao.delete("deleteExecsql", map);
		}
		List<TbSqlCfg> listSqlCfg = dbDao.selectList("selectSqlCfg", funcId);// 获取配置
		dealSingeParam(listSqlCfg, dataTime, businessParam);// 处理单值替换参数

		List<TbExecsql> listExecsql = new ArrayList<TbExecsql>();
		LongAdapter seq = new LongAdapter(1);
		for (TbSqlCfg tbSqlCfg : listSqlCfg) {// 逐个处理待执行对象set类型替换参数
			dealSetParam(listExecsql, new TreeMap<String, List<String>>(
					getSetParam(dataTime, businessParam)), tbSqlCfg, dataTime,
					tbSqlCfg.getMemo(), tbSqlCfg.getExecsql(), seq);
		}
		// 处理依赖参数
		dealDependentParam(listExecsql);
		return listExecsql;
	}

	public void addTbExecsql(List<TbExecsql> list, String businessParam) {
		for (TbExecsql tbExecsql : list) {
			tbExecsql.setBusinessparam(businessParam);
			dbDao.insert("insertExecsql", tbExecsql);
		}
	}

	/**
	 * 将sql配置添加到tb_sql_cfg中
	 * 
	 * @param list
	 */
	public void addTbSqlCfg(List<TbSqlCfg> list) {
		for (TbSqlCfg tbSqlCfg : list) {
			dbDao.insert("insertSqlCfg", tbSqlCfg);
		}
	}

	public int getExecsqlRows(String funcId, String dataTime,
			String businessParam) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("funcId", funcId);
		map.put("datatime", dataTime);
		map.put("businessParam", businessParam);
		return (Integer) dbDao.selectOne("selectCntExecsql", map);
	}

	public int removeTbSqlCfg(String funcId) {
		return dbDao.delete("deleteSqlCfg", funcId);
	}

	public int getSqlCfgRows(String funcId) {
		return (Integer) dbDao.selectOne("selectCntSqlCfg", funcId);
	}

	/**
	 * 获取常量值的sql
	 * 
	 * @param valExpr
	 *            常量值表达式
	 * @return
	 */
	public abstract String getConStantValueSql(String valExpr);

}
