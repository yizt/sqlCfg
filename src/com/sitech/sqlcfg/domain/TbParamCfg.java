package com.sitech.sqlcfg.domain; /*** @Type TbParamCfg* @Desc  通用替换参数配置表* @author yzt* @date 2013-06-20 10:01:32* @Version V1.0 */	public class TbParamCfg {	 /**		 *功能id；commom-公共；其它-具体的func_id使用		 */		private String funcId;	 /**		 *参数类型；in-传入参数；single-单值替换；set-数据集合替换		 */		private String paramType;	 /**		 *替换参数名称		 */		private String paramName;	 /**		 *参数说明		 */		private String paramDesc;	 /**		 *参数格式		 */		private String paramFormat;	 /**		 *参数取值表达式		 */		private String paramValExpr;	 /**		 *是否有效；1-有效；0-无效		 */		private String enable;	 /**		 *替换顺序		 */		private Long replaceOrder;	public String getFuncid() {		return funcId;	}	public void setFuncid(String funcId) {		this.funcId = funcId;	}	public String getParamtype() {		return paramType;	}	public void setParamtype(String paramType) {		this.paramType = paramType;	}	public String getParamname() {		return paramName;	}	public void setParamname(String paramName) {		this.paramName = paramName;	}	public String getParamdesc() {		return paramDesc;	}	public void setParamdesc(String paramDesc) {		this.paramDesc = paramDesc;	}	public String getParamformat() {		return paramFormat;	}	public void setParamformat(String paramFormat) {		this.paramFormat = paramFormat;	}	public String getParamvalexpr() {		return paramValExpr;	}	public void setParamvalexpr(String paramValExpr) {		this.paramValExpr = paramValExpr;	}	public String getEnable() {		return enable;	}	public void setEnable(String enable) {		this.enable = enable;	}	public Long getReplaceorder() {		return replaceOrder;	}	public void setReplaceorder(Long replaceOrder) {		this.replaceOrder = replaceOrder;	}}