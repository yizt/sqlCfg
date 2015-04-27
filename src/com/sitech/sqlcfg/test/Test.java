package com.sitech.sqlcfg.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitech.sqlcfg.check.service.CheckService;
import com.sitech.sqlcfg.domain.TbSqlCfg;
import com.sitech.sqlcfg.parse.service.ParseService;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="http://121.199.31.234:8001/auth/oauthServlet";
		System.out.println(urlEncodeUTF8(str));
		// TODO Auto-generated method stub
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:applicationContext.xml");
//		ParseService parService = (ParseService) context
//				.getBean("parseService");
//		CheckService checkService = (CheckService) context
//		.getBean("checkService");
		
//		List<TbExecsql> list=parService.parse("test_param","20130621","redo","aa");
//		checkService.check(list);
//		parService.addTbExecsql(list,"aa");
		//System.out.println("huanghea".substring(0, 6));
//		Long val=Long.valueOf(3);
//		testAdd(val);
//		System.out.println(val.longValue());
//		SortedMap map=new TreeMap<String, String>();
//		System.out.println(map.size());
//		System.out.println(map.firstKey());
		TbSqlCfg tbSqlCfg=new TbSqlCfg();
//		tbSqlCfg.setSeq(new Long(1));
//	    tbSqlCfg.setFuncid("test_hh");
//	    tbSqlCfg.setCfgkey("abcd");
//	    tbSqlCfg.setMemo("黄玉");
//	    tbSqlCfg.setExecsql("wwwwwww");
//	    tbSqlCfg.setEnable("1");
	    
	    List<TbSqlCfg> list=new ArrayList<TbSqlCfg>();
    	list.add(tbSqlCfg);
    	//parService.addTbSqlCfg(list);
	}
    public static void  testAdd(Long seq)
    {
    	seq=Long.valueOf(seq.longValue()+1);
    	System.out.println(seq.longValue());
    	//JdbcType.TIME;
    	//org.apache.ibatis.type.JdbcType.TIME
    	
    }
    public static void testAddSqlCfg(TbSqlCfg tbSqlCfg)
    {
    	List<TbSqlCfg> list=new ArrayList<TbSqlCfg>();
    	list.add(tbSqlCfg);
    	ParseService parseService=new ParseService();
    	parseService.addTbSqlCfg(list);
    }
    public static String urlEncodeUTF8(String source){
    	String result=source;
    	try {
			result=java.net.URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return result;
    }
}
