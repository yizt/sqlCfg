package com.sitech.sqlcfg.check.impl;

import com.sitech.sqlcfg.check.CheckPlugin;

/**
 * oracle语法检测类
 * 
 * @author yzt
 * 
 */
public class OracleCheck extends CheckPlugin {

	/**
	 * 检测单个脚本语法
	 * 
	 * @param sql
	 *            待检测脚本
	 * @return 检测结果
	 */
	public String check(String sql) {
		String checkResult = "语法正确";
		String checkSql;
		if (sql.toUpperCase().startsWith("BEGIN")
				|| sql.toUpperCase().startsWith("DECLARE"))
			checkResult = "不能检查sql块的语法！";
		else if (sql.toUpperCase().startsWith("TRUNCATE")
				|| sql.toUpperCase().startsWith("DROP"))
			checkResult = "不能检查TRUNCATE或DROP语句的语法！";
		else if (sql.toUpperCase().startsWith("ALTER"))
			checkResult = "不能检查ALTER语句的语法！";
		else {
			checkSql = "EXPLAIN PLAN FOR " + sql;
			try {
				dbDao.executeDML(checkSql);
			} catch (Exception e) {
				checkResult = e.getCause().getMessage();
			}
		}
		return checkResult;
	}

}
