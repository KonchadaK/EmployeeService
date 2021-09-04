package com.mycompany.demo.controller;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.demo.service.DemoServiceInterface;

@RestController
@RequestMapping("/demo")
/**
 * 
 * @author Krish
 *
 */
public class DemoController {
	
	@Autowired
	DemoServiceInterface service;
	
	/**
	 * logger to log proper debug messages
	 */
   private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@RequestMapping("/format")
	/**
	 * formats input data to the specification
	 * @param houseData
	 * @return
	 */
	@ExceptionHandler(IOException.class)
	public ResponseEntity<String> formatInput(@RequestBody String houseData) {
		
		String response = "";
		
		logger.info("calling service method");
		try {
			response = service.formatInput(houseData);
		} catch (IOException ex) {
			logger.error(ex.getMessage());
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	  	return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
