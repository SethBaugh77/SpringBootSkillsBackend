package com.example.springbootdash.springbootdash.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<String> handleDuplicate(DuplicateEntryException e){
     return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleDuplicate(UserNotFoundException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }


}
