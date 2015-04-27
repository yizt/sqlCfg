package com.sitech.sqlcfg.dao;

import com.sitech.sqlcfg.util.DesEncrypterIsmp;

/**
 * 自定义数据源处理密码加密问题
 * 
 * @author yzt
 * 
 */
public class SitechDataSource extends org.apache.commons.dbcp.BasicDataSource {

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		DesEncrypterIsmp des = new DesEncrypterIsmp();
		//System.out.println("===密码==="+des.decrypt(password));
		super.setPassword(des.decrypt(password));
	}
}
