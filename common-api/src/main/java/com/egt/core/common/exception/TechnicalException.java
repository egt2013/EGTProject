package com.egt.core.common.exception;

public class TechnicalException extends EGTException{

	private static final long serialVersionUID = 1L;
	public TechnicalException(){
		this(null);
	}
	
	public TechnicalException(Throwable thrw) {
		super(EGTException.TECHNICAL_ERR_CODE);
		errMsg = EGTException.TECHNICAL_ERR_MSG;
		super.thrw = thrw;
	}
}
