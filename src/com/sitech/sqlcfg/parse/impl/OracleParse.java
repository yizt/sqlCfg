package com.sitech.sqlcfg.parse.impl;

import com.sitech.sqlcfg.parse.ParsePlugin;

/**
 * Oracle数据库解析
 * 
 * @author yzt
 * 
 */
public class OracleParse extends ParsePlugin {

	/**
	 * 获取常量值的sql
	 * 
	 * @param valExpr
	 *            常量值表达式
	 * @return
	 */
	public String getConStantValueSql(String valExpr) {
		return "select " + valExpr + " from dual";
	}

}
