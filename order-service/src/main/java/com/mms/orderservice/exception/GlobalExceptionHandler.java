package com.mms.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler
    public final ResponseEntity<Object> handleOrderNotFound(OrderNotFoundException ex,
    WebRequest request){

        OrderNotFoundExceptionResponse response = new OrderNotFoundExceptionResponse(ex.getMessage());
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleCartAlreadyExists(CartAlreadyExistsException ex,
    WebRequest request){
        CartAlreadyExistsExceptionResponse response = new CartAlreadyExistsExceptionResponse(ex.getMessage());
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleCartNotFound(CartNotFoundException ex,
    WebRequest request){

        CartNotFoundExceptionResponse response = new CartNotFoundExceptionResponse(ex.getMessage());
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

}
