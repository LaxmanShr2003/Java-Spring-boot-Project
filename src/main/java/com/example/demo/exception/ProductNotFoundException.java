package com.example.demo.exception;

public class ProductNotFoundException extends RuntimeException{

public ProductNotFoundException(String message){
    super(message);
}

    public ProductNotFoundException(Throwable cause, String message){
        super(message,cause);
    }

}
