package com.mms.userservice.exception;

public class UserNotFoundExceptionResponse {
    
    private String username;

    public UserNotFoundExceptionResponse() {
    }

    public UserNotFoundExceptionResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
}
