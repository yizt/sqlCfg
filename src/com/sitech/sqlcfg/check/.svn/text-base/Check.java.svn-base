package com.sitech.sqlcfg.check;

import java.util.List;

import com.sitech.sqlcfg.domain.TbExecsql;

/**
 * 语法检测接口
 * 
 * @author yzt
 * 
 */
public interface Check {
	/**
	 * 语法检测
	 * 
	 * @param list
	 *            待执行脚本对象集合
	 */
	public void check(List<TbExecsql> list);

	/**
	 * 检测单个脚本语法
	 * 
	 * @param sql
	 *            待检测脚本
	 * @return 检测结果
	 */
	public String check(String sql);
}
