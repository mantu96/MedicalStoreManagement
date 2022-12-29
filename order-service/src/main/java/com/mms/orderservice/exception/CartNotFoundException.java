package com.mms.orderservice.exception;

public class CartNotFoundException extends RuntimeException {

    public CartNotFoundException() {
    }

    public CartNotFoundException(String error) {
        super(error);
    }
    
    
}
