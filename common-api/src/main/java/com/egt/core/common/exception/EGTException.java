package com.egt.core.common.exception;

public class EGTException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public static final String TECHNICAL_ERR_CODE = "C0001";
	public static final String TECHNICAL_ERR_MSG = "TechnicalException";
	
	public static final String DATABASE_ERR_CODE = "C0002";
	public static final String DATABASE_ERR_MSG = "DatabaseException";
	
	public static final String LOGIN_INVALID_ERR_CODE = "C0003";
	public static final String LOGIN_INVALID_ERR_MSG = "LoginInvalidException";
	
	protected String errCode = "";
	protected String errMsg = "";
	protected String var1 = "";
	protected String var2 = "";
	protected String var3 = "";
	protected Throwable thrw;
	
	public EGTException(String errCode,Throwable thrw){
		this.errCode = errCode;
		this.thrw = thrw;
	}
	
	public EGTException(Throwable thrw){
		this.thrw = thrw;
	}
	
	public EGTException(String errCode){
		this.errCode = errCode;
	}
	
	public EGTException(String errCode,String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	public EGTException(String errCode, String var1,Throwable thrw){
		this.errCode = errCode;
		this.var1 = var1;
		this.thrw = thrw;
	}
	
	public EGTException(String errCode, String var1, String var2, String var3) {
		this.errCode = errCode;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
	}

	
	public EGTException(String errCode, String var1, String var2, String var3,Throwable thrw) {
		this.errCode = errCode;
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.thrw = thrw;
	}	
	
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getVar1() {
		return var1;
	}
	public void setVar1(String var1) {
		this.var1 = var1;
	}
	public String getVar2() {
		return var2;
	}
	public void setVar2(String var2) {
		this.var2 = var2;
	}
	public String getVar3() {
		return var3;
	}
	public void setVar3(String var3) {
		this.var3 = var3;
	}
	public Throwable getThrw() {
		return thrw;
	}
	public void setThrw(Throwable thrw) {
		this.thrw = thrw;
	}
	
}
