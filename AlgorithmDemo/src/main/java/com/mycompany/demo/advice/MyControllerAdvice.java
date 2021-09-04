package com.mycompany.demo.advice;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mycompany.demo.exception.MyException;

@RestControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<String> handleMyException(MyException ex) {
		return new ResponseEntity<String>("Error processing request, please try again", HttpStatus.BAD_REQUEST);
	}

}
