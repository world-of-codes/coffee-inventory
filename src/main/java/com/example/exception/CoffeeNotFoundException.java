package com.example.exception;

public class CoffeeNotFoundException  extends  RuntimeException{
    public CoffeeNotFoundException(String message) {
        super(message);
    }
}
