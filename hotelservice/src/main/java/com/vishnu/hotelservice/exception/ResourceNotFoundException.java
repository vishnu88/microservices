package com.vishnu.hotelservice.exception;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super("Resource not found "+message);
    }
}
