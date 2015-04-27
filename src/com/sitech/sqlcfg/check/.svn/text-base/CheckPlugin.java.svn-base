package com.sitech.sqlcfg.check;

import java.util.List;

import com.sitech.sqlcfg.domain.TbExecsql;
import com.sitech.sqlcfg.util.Plugin;

public abstract class CheckPlugin extends Plugin implements Check {

	public void check(List<TbExecsql> list) {
		for (TbExecsql tbExecsql : list) {
			tbExecsql.setCheckerr(check(tbExecsql.getExecsql()));
		}
	}

	/**
	 * 检测单个脚本语法
	 * 
	 * @param sql
	 *            待检测脚本
	 * @return 检测结果
	 */
	public abstract String check(String sql) ;
	
}
