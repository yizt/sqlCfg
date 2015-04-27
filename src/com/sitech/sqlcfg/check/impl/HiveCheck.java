package com.sitech.sqlcfg.check.impl;

/**
 * hive语法检测
 * 
 * @author yzt
 * 
 */
public class HiveCheck extends OracleCheck {
	/**
	 * 检测单个脚本语法
	 * 
	 * @param sql
	 *            待检测脚本
	 * @return 检测结果
	 */
	@Override
	public String check(String sql) {
		String checkResult = "语法正确";
		String checkSql;

		checkSql = "EXPLAIN " + sql;
		try {
			dbDao.executeDML(checkSql);
		} catch (Exception e) {
			// TODO: handle exception
			checkResult = e.getCause().getMessage();
		}

		return checkResult;
	}
}
