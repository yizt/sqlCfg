package com.sitech.sqlcfg.domain; /*** @Type TbSqlCfg* @Desc  通用sql配置表* @author yzt* @date 2013-06-20 10:01:32* @Version V1.0 */	public class TbSqlCfg {	 /**		 *执行顺序		 */		private Long seq;	 /**		 *功能标识(以'模块标志_'开头)		 */		private String funcId;	 /**		 *配置标志，在功能中标志该sql脚本		 */		private String cfgKey;	 /**		 *说明		 */		private String memo;	 /**		 *执行的sql		 */		private String execSql;	 /**		 *参数键；在程序中不实际起作用，方便查看替换的参数		 */		private String parmKey;	 /**		 *参数值；在程序中不实际起作用，方便查看替换的参数		 */		private String parmVal;	 /**		 *是否有效；1-有效；0-无效		 */		private String enable;	 /**		 *依赖关系		 */		private Long dependent;	 /**		 *统计日期：(日期集合)		 */		private String statDays;	public Long getSeq() {		return seq;	}	public void setSeq(Long seq) {		this.seq = seq;	}	public String getFuncid() {		return funcId;	}	public void setFuncid(String funcId) {		this.funcId = funcId;	}	public String getCfgkey() {		return cfgKey;	}	public void setCfgkey(String cfgKey) {		this.cfgKey = cfgKey;	}	public String getMemo() {		return memo;	}	public void setMemo(String memo) {		this.memo = memo;	}	public String getExecsql() {		return execSql;	}	public void setExecsql(String execSql) {		this.execSql = execSql;	}	public String getParmkey() {		return parmKey;	}	public void setParmkey(String parmKey) {		this.parmKey = parmKey;	}	public String getParmval() {		return parmVal;	}	public void setParmval(String parmVal) {		this.parmVal = parmVal;	}	public String getEnable() {		return enable;	}	public void setEnable(String enable) {		this.enable = enable;	}	public Long getDependent() {		return dependent;	}	public void setDependent(Long dependent) {		this.dependent = dependent;	}	public String getStatdays() {		return statDays;	}	public void setStatdays(String statDays) {		this.statDays = statDays;	}}