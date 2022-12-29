package com.mms.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
   
    
	@ExceptionHandler
	public final ResponseEntity<Object> handleProductNotFound(ProductNotFoundException ex, WebRequest request) {
		ProductNotFoundExceptionResponse response = new ProductNotFoundExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> ProductAlreadyExistException(ProductAlreadyExistsException ex, WebRequest request) {
		ProductAlreadyExistsExceptionResponse response = new ProductAlreadyExistsExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
}
