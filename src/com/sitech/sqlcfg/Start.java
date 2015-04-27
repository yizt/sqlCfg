package com.sitech.sqlcfg;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitech.sqlcfg.check.service.CheckService;
import com.sitech.sqlcfg.domain.TbExecsql;
import com.sitech.sqlcfg.parse.service.ParseService;
import com.sitech.sqlcfg.run.service.RunService;

public class Start {
	static Logger log = Logger.getLogger(Start.class);

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String funcId = args[0];// 功能标识
		String dataTime = args[1];// 数据时间
		/*
		 * 模式 normal-正常解析执行，若已解析执行过，不重新解析，从未执行完成的地方开始执行;
		 * redo-先删除存在的执行记录；然后重新解析执行 ; debug-先删除存在的执行记录，然后重新解析，不执行，用于开发阶段检测语法;
		 */
		String mode = args[2];
		String businessParam;// 业务参数
		if (args.length >= 4) {
			businessParam = args[3];
		} else {
			businessParam = null;
		}
		log.debug("开始执行sql解析执行funcId=" + funcId + ";=dataTime" + dataTime
				+ ";=mode" + mode + ";=businessParam" + businessParam);
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		ParseService parService = (ParseService) context
				.getBean("parseService");
		CheckService checkService = (CheckService) context
				.getBean("checkService");
		RunService runService = (RunService) context.getBean("runService");
		// 当运行模式normal且已存在待执行记录则跳过
		if ("normal".equals(mode)
				&& 0 < parService.getExecsqlRows(funcId, dataTime,
						businessParam)) {
		} else {
			List<TbExecsql> list = parService.parse(funcId, dataTime, mode,
					businessParam);
			checkService.check(list);
			parService.addTbExecsql(list, businessParam);
		}
		// 执行脚本
		runService.run(funcId, dataTime, mode, businessParam);
		log.debug("完成执行sql解析执行funcId=" + funcId + ";=dataTime" + dataTime
				+ ";=mode" + mode + ";=businessParam" + businessParam);
	}

}
