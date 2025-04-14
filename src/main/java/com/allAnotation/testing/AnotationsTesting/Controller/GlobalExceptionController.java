package com.allAnotation.testing.AnotationsTesting.Controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.allAnotation.testing.AnotationsTesting.Constant.Constant;
import com.allAnotation.testing.AnotationsTesting.Entity.ExceptionResponse;
import com.allAnotation.testing.AnotationsTesting.Exception.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseBody
	public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException exception){
		
		ExceptionResponse exceptionDetails = new ExceptionResponse(Constant.notFound,LocalDateTime.now(),exception.getMessage());
		return new ResponseEntity<>(exceptionDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception error){
		ExceptionResponse exceptionDetails = new ExceptionResponse(Constant.badRequest,LocalDateTime.now(),error.getMessage());
		return new ResponseEntity<>(exceptionDetails,HttpStatus.BAD_REQUEST);
	}

}
