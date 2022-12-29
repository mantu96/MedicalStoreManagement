package com.mms.orderservice.exception;

public class CartNotFoundExceptionResponse {
    
    private String cartId;

    public CartNotFoundExceptionResponse(){
        super();
    }

    public CartNotFoundExceptionResponse(String cartId) {
        super();
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    
    
}
