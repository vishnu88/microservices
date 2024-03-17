package com.vishnu.userservice.exception;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(){
        super("Reource not found");
    }

    ResourceNotFoundException(String exp){
        super(exp+" Resource not found");
    }
}
