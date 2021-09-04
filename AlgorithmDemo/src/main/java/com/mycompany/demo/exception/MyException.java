package com.mycompany.demo.exception;

public class MyException extends Exception {
	
	String message;
	public MyException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
