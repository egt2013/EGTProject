package com.egt.core.common.exception;

public class LoginInvalidException extends EGTException{
	private static final long serialVersionUID = 1L;
	public LoginInvalidException(){
		this(null);
	}
	
	public LoginInvalidException(Throwable thrw) {
		super(EGTException.LOGIN_INVALID_ERR_CODE);
		errMsg = EGTException.LOGIN_INVALID_ERR_MSG;
		super.thrw = thrw;
	}
}
