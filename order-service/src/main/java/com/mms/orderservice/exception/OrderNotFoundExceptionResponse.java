package com.mms.orderservice.exception;

public class OrderNotFoundExceptionResponse {
    
    private String orderId;

    public OrderNotFoundExceptionResponse(){
        super();
    }

    public OrderNotFoundExceptionResponse(String orderId) {
        super();
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    
    
}
