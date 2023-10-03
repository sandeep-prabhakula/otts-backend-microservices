package com.sandeepprabhakula.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler()
    public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(RecordNotFoundException exception){
        Map<String,Object>map = new HashMap<>();
        String message = exception.getMessage();
        map.put("Message",message);
        map.put("success",true);
        map.put("status", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
