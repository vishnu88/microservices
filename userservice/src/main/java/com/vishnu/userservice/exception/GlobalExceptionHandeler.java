package com.vishnu.userservice.exception;

import com.vishnu.userservice.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> hanleGlobleException(ResourceNotFoundException exp) {
        String message = exp.getMessage();
        APIResponse response = APIResponse.builder().message(message).status(true).build();
        return new ResponseEntity<APIResponse>(response, HttpStatus.NOT_FOUND);
    }

}