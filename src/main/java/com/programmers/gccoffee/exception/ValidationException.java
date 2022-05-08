package com.programmers.gccoffee.exception;

public class ValidationException extends BusinessException{
    public ValidationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
