package com.sitech.sqlcfg.run.service;

import com.sitech.sqlcfg.run.Run;

public class RunService {
	private Run run;
	
	public Run getRun() {
		return run;
	}

	public void setRun(Run run) {
		this.run = run;
	}

	/**
	 * 执行脚本
	 * 
	 * @param funcId
	 *            功能标志
	 * @param dataTime
	 *            数据时间
	 * @param mode
	 *            模式 normal、redo执行，debug不执行
	 * @param businessParam
	 *            业务参数
	 * @return
	 * @throws Exception 
	 */
	public void run(String funcId, String dataTime, String mode,
			String businessParam) throws Exception{
		 run.run(funcId, dataTime, mode, businessParam);
	}
}
