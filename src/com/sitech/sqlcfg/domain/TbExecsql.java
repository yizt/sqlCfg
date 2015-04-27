package com.sitech.sqlcfg.domain; import java.util.Date; /*** @Type TbExecsql* @Desc  通用sql执行表* @author yzt* @date 2013-06-20 10:01:32* @Version V1.0 */	public class TbExecsql {	 /**		 *数据时间		 */		private String datatime;	 /**		 *功能标识		 */		private String funcId;	 /**		 *执行顺序		 */		private Long seq;	 /**		 *说明		 */		private String memo;	 /**		 *执行的sql		 */		private String execSql;	 /**		 *0:成功；其它失败		 */		private Long flag;	 /**		 *运行错误信息（可以记录多次错误的信息）		 */		private String errMsg;	 /**		 *影响的行数		 */		private Long affectRownum;	 /**		 *开始时间		 */		private Date startTime;	 /**		 *结束时间		 */		private Date endTime;	 /**		 *执行消耗时间（秒）		 */		private Long execElapsed;	 /**		 *预定执行日期		 */		private Date execDate;	 /**		 *语法检查错误信息		 */		private String checkErr;	 /**		 *依赖关系		 */		private Long dependent;	 /**		 *业务参数		 */		private String businessParam;	public String getDatatime() {		return datatime;	}	public void setDatatime(String datatime) {		this.datatime = datatime;	}	public String getFuncid() {		return funcId;	}	public void setFuncid(String funcId) {		this.funcId = funcId;	}	public Long getSeq() {		return seq;	}	public void setSeq(Long seq) {		this.seq = seq;	}	public String getMemo() {		return memo;	}	public void setMemo(String memo) {		this.memo = memo;	}	public String getExecsql() {		return execSql;	}	public void setExecsql(String execSql) {		this.execSql = execSql;	}	public Long getFlag() {		return flag;	}	public void setFlag(Long flag) {		this.flag = flag;	}	public String getErrmsg() {		return errMsg;	}	public void setErrmsg(String errMsg) {		this.errMsg = errMsg;	}	public Long getAffectrownum() {		return affectRownum;	}	public void setAffectrownum(Long affectRownum) {		this.affectRownum = affectRownum;	}	public Date getStarttime() {		return startTime;	}	public void setStarttime(Date startTime) {		this.startTime = startTime;	}	public Date getEndtime() {		return endTime;	}	public void setEndtime(Date endTime) {		this.endTime = endTime;	}	public Long getExecelapsed() {		return execElapsed;	}	public void setExecelapsed(Long execElapsed) {		this.execElapsed = execElapsed;	}	public Date getExecdate() {		return execDate;	}	public void setExecdate(Date execDate) {		this.execDate = execDate;	}	public String getCheckerr() {		return checkErr;	}	public void setCheckerr(String checkErr) {		this.checkErr = checkErr;	}	public Long getDependent() {		return dependent;	}	public void setDependent(Long dependent) {		this.dependent = dependent;	}	public String getBusinessparam() {		return businessParam;	}	public void setBusinessparam(String businessParam) {		this.businessParam = businessParam;	}}