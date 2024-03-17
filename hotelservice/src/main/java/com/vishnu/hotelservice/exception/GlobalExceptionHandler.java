package com.vishnu.hotelservice.exception;

import com.vishnu.hotelservice.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.function.EntityResponse;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<APIResponse> getGlobalHandler(ResourceNotFoundException exp){
        APIResponse response = APIResponse.builder().message(exp.getMessage()).status(true).httpStatus("failed").build();
        return new ResponseEntity<APIResponse>(response, HttpStatus.NOT_FOUND);
    }

}
