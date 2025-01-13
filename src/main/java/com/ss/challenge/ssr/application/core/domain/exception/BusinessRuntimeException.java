package com.ss.challenge.ssr.application.core.domain.exception;

public class BusinessRuntimeException extends RuntimeException {

    public BusinessRuntimeException() {
        super();
    }
    public BusinessRuntimeException(String errorMessage) {
        super(errorMessage);
    }
}

