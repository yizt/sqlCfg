package com.sitech.sqlcfg.check.impl;

import com.sitech.sqlcfg.check.CheckPlugin;

/**
 * mysql语法检测类型
 * 
 * @author yzt
 * 
 */
public class MysqlCheck extends CheckPlugin {
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
			//用explain的好处
//			checkSql = "EXPLAIN " + sql;
			checkSql=sql;
			try {
				dbDao.executeDML(checkSql);
			} catch (Exception e) {
				// TODO: handle exception
				checkResult = e.getCause().getMessage();
			}
		}
		return checkResult;
	}
	
}
