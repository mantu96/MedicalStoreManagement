package com.mms.orderservice.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(){
        super();
    }
    
    public OrderNotFoundException(String error){
        super(error);
    }
}
