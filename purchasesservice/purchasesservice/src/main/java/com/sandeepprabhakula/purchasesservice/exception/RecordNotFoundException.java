package com.sandeepprabhakula.purchasesservice.exception;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(){
        super("Record not found");
    }
    public RecordNotFoundException(String message){
        super(message);
    }
}
