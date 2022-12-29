package com.mms.productservice.exception;

public class ProductNotFoundExceptionResponse {
    
    private String message;

	public ProductNotFoundExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ProductNotFoundExceptionResponse(String message) {
		super();
		this.message = message;
	}
	
}
