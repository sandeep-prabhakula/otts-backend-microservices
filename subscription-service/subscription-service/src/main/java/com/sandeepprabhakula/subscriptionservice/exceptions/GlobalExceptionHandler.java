package com.sandeepprabhakula.subscriptionservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Map<String,Object>>recordNotFoundExceptionHandler(RecordNotFoundException exception){
        Map<String,Object>map = new HashMap<>();
        map.put("Message",exception.getMessage());
        map.put("Status",HttpStatus.NOT_FOUND);
        map.put("Success",true);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
