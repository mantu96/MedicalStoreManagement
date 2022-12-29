package com.mms.productservice.exception;

public class ProductAlreadyExistsExceptionResponse {
    
    private String productIdentifier;

    public ProductAlreadyExistsExceptionResponse() {
    }

    public ProductAlreadyExistsExceptionResponse(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    
}
