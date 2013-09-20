package com.egt.core.common.exception;

public class DatabaseException extends EGTException{
	private static final long serialVersionUID = 1L;
	public DatabaseException(){
		this(null);
	}
	
	public DatabaseException(Throwable thrw) {
		super(EGTException.DATABASE_ERR_CODE);
		errMsg = EGTException.DATABASE_ERR_MSG;
		super.thrw = thrw;
	}
}
