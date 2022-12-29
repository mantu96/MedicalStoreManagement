package com.mms.orderservice.exception;

public class CartAlreadyExistsException extends RuntimeException {
    
    public CartAlreadyExistsException(){

    }
    
    public CartAlreadyExistsException(String error){
        super(error);
    }
}
