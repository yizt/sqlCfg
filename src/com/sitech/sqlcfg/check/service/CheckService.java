package com.sitech.sqlcfg.check.service;

import java.util.List;

import com.sitech.sqlcfg.check.Check;
import com.sitech.sqlcfg.domain.TbExecsql;

/**
 * 语法检测服务类
 * 
 * @author yzt
 * 
 */
public class CheckService {
	private Check check;

	public Check getCheck() {
		return check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	/**
	 * 语法检测
	 * 
	 * @param list
	 *            待执行脚本对象集合
	 */
	public void check(List<TbExecsql> list) {
		check.check(list);
	}

	/**
	 * 检测单个脚本语法
	 * 
	 * @param sql
	 *            待检测脚本
	 * @return 检测结果
	 */
	public String check(String sql) {
		return check.check(sql);
	}
}
