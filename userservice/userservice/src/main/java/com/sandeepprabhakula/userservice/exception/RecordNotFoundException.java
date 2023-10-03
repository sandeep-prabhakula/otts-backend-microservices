package com.sandeepprabhakula.userservice.exception;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(){
        super("data not found");
    }
    public RecordNotFoundException(String message){
        super(message);
    }
}
