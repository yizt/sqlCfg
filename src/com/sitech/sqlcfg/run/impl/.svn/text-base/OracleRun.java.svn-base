package com.sitech.sqlcfg.run.impl;

import com.sitech.sqlcfg.domain.TbExecsql;
import com.sitech.sqlcfg.run.RunPlugin;

/**
 * oracle脚本执行类型
 * 
 * @author yzt
 * 
 */
public class OracleRun extends RunPlugin {

	/**
	 * 更新执行记录表
	 * 
	 * @param tbExecsql
	 *            执行对象
	 */
	public void update(TbExecsql tbExecsql) {
		dbDao.update("updateExecsql", tbExecsql);// 更新表
	}

}
