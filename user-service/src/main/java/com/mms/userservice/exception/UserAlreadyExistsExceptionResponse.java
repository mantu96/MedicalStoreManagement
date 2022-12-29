package com.mms.userservice.exception;

public class UserAlreadyExistsExceptionResponse {
    
    private String username;

    
    public UserAlreadyExistsExceptionResponse() {
    }

    public UserAlreadyExistsExceptionResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
}
