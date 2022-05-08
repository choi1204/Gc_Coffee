package com.programmers.gccoffee.exception;

public class DuplicationException extends BusinessException{
    public DuplicationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
