package com.sitech.sqlcfg.util;
/**
 * sql字符串适配器,由于String缺少get方法
 * @author yzt
 *
 */
public class SQLAdapter {   
    String sql;   
  
    public SQLAdapter(String sql) {   
        this.sql = sql;   
    }   
  
    public String getSql() {   
        return sql;   
    }   
  
    public void setSql(String sql) {   
        this.sql = sql;   
    }   
}  
