package com.sitech.sqlcfg.run.impl;

import com.sitech.sqlcfg.domain.TbExecsql;
import com.sitech.sqlcfg.run.RunPlugin;

/**
 * mysql脚本执行类
 * 
 * @author yzt
 * 
 */
public class MysqlRun extends RunPlugin {
	/**
	 * 更新执行记录表
	 * 
	 * @param tbExecsql
	 *            执行对象
	 */
	public void update(TbExecsql tbExecsql) {
		dbDao.update("updateExecsqlForMysql", tbExecsql);// 更新表
	}
}
