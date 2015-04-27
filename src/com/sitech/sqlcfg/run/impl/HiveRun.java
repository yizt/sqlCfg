package com.sitech.sqlcfg.run.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.sitech.sqlcfg.dao.DBDao;
import com.sitech.sqlcfg.domain.TbExecsql;
import com.sitech.sqlcfg.run.Run;

/**
 * hive执行类
 * 
 * @author yzt
 * 
 */
public class HiveRun implements Run {
	protected String dbType;

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	/**
	 * 数据库连接,用于记录hql执行情况的信息
	 */
	protected DBDao dbDao;

	public DBDao getDbDao() {
		return dbDao;
	}

	public void setDbDao(DBDao dbDao) {
		this.dbDao = dbDao;
	}

	/**
	 * hive连接，用于执行hql
	 */
	protected DBDao hiveDao;

	public DBDao getHiveDao() {
		return hiveDao;
	}

	public void setHiveDao(DBDao hiveDao) {
		this.hiveDao = hiveDao;
	}

	@Override
	public void run(String funcId, String dataTime, String mode,
			String businessParam) throws Exception {
		// TODO Auto-generated method stub
		if ("debug".equals(mode)) {
			return;
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("funcId", funcId);
		map.put("datatime", dataTime);
		map.put("businessParam", businessParam);
		List<TbExecsql> list;
		int errTimes = 0;
		Exception exception = null;
		list = dbDao.selectList("selectExecsql", map);
		// 逐条记录执行
		for (TbExecsql tbExecsql : list) {
			errTimes = 0;
			while (errTimes <= 3) {
				try {
					tbExecsql.setStarttime(new Date());// 开始时间
					tbExecsql.setAffectrownum((long) hiveDao.executeDML(tbExecsql
							.getExecsql()));// 影响行数
					tbExecsql.setEndtime(new Date());// 结束时间
					tbExecsql
							.setExecelapsed((tbExecsql.getEndtime().getTime() - tbExecsql
									.getStarttime().getTime()) / 1000);// 执行耗时
					tbExecsql.setFlag((long) 0);// 执行标志
					update(tbExecsql);// 更新表
					exception = null;
					break;// 正常退出
				} catch (Exception e) {
					// TODO: handle exception
					tbExecsql.setErrmsg(e.getCause().getMessage());
					update(tbExecsql);// 更新表
					errTimes = errTimes + 1;
					exception = e;
				}
			}
			// 重做超过3次并且最后那次出错，抛出异常
			if (null != exception && errTimes > 3) {
				throw exception;
			}
		}

	}

	/**
	 * 更新执行记录表
	 * 
	 * @param tbExecsql
	 *            执行对象
	 */
	public void update(TbExecsql tbExecsql) {
		if ("oracle".equals(dbType)) {
			dbDao.update("updateExecsql", tbExecsql);// 更新表
		} else if ("mysql".equals(dbType)) {
			dbDao.update("updateExecsqlForMysql", tbExecsql);// 更新表
		}

	}

}
