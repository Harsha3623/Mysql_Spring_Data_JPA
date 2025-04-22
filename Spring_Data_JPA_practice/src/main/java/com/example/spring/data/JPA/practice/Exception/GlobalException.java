package com.example.spring.data.JPA.practice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {

    //handles the exception raised when the validation of input parameters is incorrect
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validateInput(MethodArgumentNotValidException ex){
        Map<String,String> error = new HashMap<>();
        for(FieldError er: ex.getBindingResult().getFieldErrors()){
            error.put(er.getField(),er.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    //handle exception when we use incorrect http method like
    //instead of get request we use put request it handles the exception
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> methodNotAllowed(HttpRequestMethodNotSupportedException ex){
    return new ResponseEntity<>("HTTP Method Not Supported: "+ex.getMethod(),HttpStatus.METHOD_NOT_ALLOWED);
    }

}
