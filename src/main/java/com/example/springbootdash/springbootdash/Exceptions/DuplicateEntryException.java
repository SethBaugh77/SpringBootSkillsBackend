package com.example.springbootdash.springbootdash.Exceptions;

public class DuplicateEntryException extends RuntimeException {
    public DuplicateEntryException(String message){
        super(message);
    }
}
