package com.mycompany.employeeservice.exception;

public class EmptyInputException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4846880486799115656L;
	private String message;
	
	public EmptyInputException(String msg) {
		message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
