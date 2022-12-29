package com.mms.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<?> handleUserAlreadyExistException(UserAlreadyExistsException ex,
    WebRequest request){

        UserAlreadyExistsExceptionResponse response = new UserAlreadyExistsExceptionResponse(ex.getMessage());
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex,
    WebRequest request){

        UserNotFoundExceptionResponse response = new UserNotFoundExceptionResponse(ex.getMessage());
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }
}
