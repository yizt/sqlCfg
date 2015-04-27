package com.sitech.sqlcfg.parse;

import java.util.List;
import java.util.HashMap;
import com.sitech.sqlcfg.domain.TbExecsql;
import com.sitech.sqlcfg.domain.TbSqlCfg;

/**
 * 解析接口
 * 
 * @author yzt
 * 
 */
public interface Parse {
	/**
	 * 获取单值替换参数列表
	 * 
	 * @param dataTime
	 *            数据时间
	 * @param businessParam
	 *            业务参数
	 * @return 替换参数的键值对集合
	 */
	public HashMap<String, String> getSingleParam(String dataTime,
			String businessParam);

	/**
	 * 获取集合替换参数列表
	 * 
	 * @param dataTime
	 *            数据时间
	 * @param businessParam
	 *            业务参数
	 * @return 替换参数的键值对集合，其中值是集合类型
	 */
	public HashMap<String, List<String>> getSetParam(String dataTime,
			String businessParam);

	/**
	 * 将sql配置添加到tb_sql_cfg中
	 * 
	 * @param list
	 */
	public void addTbSqlCfg(List<TbSqlCfg> list);

	/**
	 * 删除tb_sql_cfg中的配置
	 * 
	 * @param funcId
	 */
	public int removeTbSqlCfg(String funcId);

	/**
	 * 解析函数-生成待执行的对象
	 * 
	 * @param funcId
	 *            功能标志
	 * @param dataTime
	 *            数据时间
	 * @param mode
	 *            生成模式 normal-正常生成；redo-重新生成；debug-重新生成
	 * @param businessParam
	 *            业务参数
	 * @return
	 */
	public List<TbExecsql> parse(String funcId, String dataTime, String mode,
			String businessParam);

	/**
	 * 将待执行脚本添加到表tb_execsql中
	 * 
	 * @param businessParam
	 *            业务参数
	 * @param list
	 *            待执行脚本对象
	 */
	public void addTbExecsql(List<TbExecsql> list, String businessParam);

	/**
	 * 获取指定功能待执行对象的行数
	 * 
	 * @param funcId
	 *            功能标志
	 * @param dataTime
	 *            数据时间
	 * @param businessParam
	 *            业务参数
	 * @return 返回行数
	 */
	public int getExecsqlRows(String funcId, String dataTime,
			String businessParam);

	/**
	 * 获取指定功能id的配置脚本行数
	 * 
	 * @param funcId
	 *            功能标志
	 * @return 返回行数
	 */
	public int getSqlCfgRows(String funcId);
}
