package com.validation.ValidationDemo.exception;

public class NoMatchAmountException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoMatchAmountException() {
		super("have to greater than 10000");
	}

}
