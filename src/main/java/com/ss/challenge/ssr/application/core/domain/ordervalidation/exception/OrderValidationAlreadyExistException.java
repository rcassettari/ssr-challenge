package com.ss.challenge.ssr.application.core.domain.ordervalidation.exception;

import com.ss.challenge.ssr.application.core.domain.exception.BusinessRuntimeException;

public class OrderValidationAlreadyExistException extends BusinessRuntimeException {

    private static final String ORDER_VALIDATION_ALREADY_EXIST_ERROR_MESSAGE = "Order Validation already exist.";

    public OrderValidationAlreadyExistException() {
        super(ORDER_VALIDATION_ALREADY_EXIST_ERROR_MESSAGE);
    }
    public OrderValidationAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}

