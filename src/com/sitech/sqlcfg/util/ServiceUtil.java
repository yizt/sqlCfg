package com.sitech.sqlcfg.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitech.sqlcfg.check.service.CheckService;
import com.sitech.sqlcfg.parse.service.ParseService;
import com.sitech.sqlcfg.run.service.RunService;

/**
 * 服务工具包
 * 
 * @author yzt
 * 
 */
public class ServiceUtil {
	private static ApplicationContext context;

	public static ApplicationContext getContext() {
		if (null == context)
			context = new ClassPathXmlApplicationContext(
					"classpath:applicationContext.xml");
		return context;
	}

	public static ParseService getParseService() {
		ParseService parService = (ParseService) getContext().getBean(
				"parseService");
		return parService;
	}

	public static CheckService getCheckService() {
		CheckService checkService = (CheckService) getContext().getBean(
				"checkService");
		return checkService;
	}

	public static RunService getRunService() {
		RunService runService = (RunService) context.getBean("runService");
		return runService;
	}
}
