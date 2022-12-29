package com.mms.orderservice.exception;

public class CartAlreadyExistsExceptionResponse {
    
    private String cartId;

    public CartAlreadyExistsExceptionResponse(){
        super();
    }

    public CartAlreadyExistsExceptionResponse(String cartId){
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
