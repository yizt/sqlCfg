package com.sitech.sqlcfg.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import com.sitech.sqlcfg.util.SQLAdapter;

public class DBDao extends SqlSessionTemplate{
	static Logger log = Logger.getLogger(DBDao.class);
	public DBDao(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 执行DML语句,包括insert,update,delete
	 * 
	 * @param sql
	 *            待执行的DML语句
	 * @return 成功返回影响的行数
	 */
	public int executeDML(String sql) {
		log.debug("开始执行sql:"+sql);
		int rows = super.update("dml", new SQLAdapter(sql));
		log.debug("完成执行sql:"+sql);
		return rows;
	}
	/**
	 * 获取查询后的结果
	 * @param sql：查詢sql
	 * @return 字符串
	 */
    public String selectString(String sql){
    	String valueString=(String) super.selectOne("selectString", new SQLAdapter(sql));
    	return valueString;
    }
    /**
	 * 获取查询后的结果
	 * @param sql：查詢sql
	 * @return 字符串集合
	 */
    public List<String> selectStringList(String sql){
    	List<String> list= super.selectList("selectString", new SQLAdapter(sql));
    	return list;
    }
}
