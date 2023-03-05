package com.emre.exception;

import lombok.Getter;

@Getter
public class UserDoLoginException extends RuntimeException{
    private final EErrorType errorType;
    public UserDoLoginException(EErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }
    public UserDoLoginException(EErrorType errorType, String message){
        super(message);
        this.errorType=errorType;
    }
}
