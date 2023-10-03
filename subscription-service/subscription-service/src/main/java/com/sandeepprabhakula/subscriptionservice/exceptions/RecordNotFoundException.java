package com.sandeepprabhakula.subscriptionservice.exceptions;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(){
        super("Record Not found ");
    }
    public RecordNotFoundException(String message){
        super(message);
    }
}
