package com.ss.challenge.ssr.application.core.domain.ordervalidation.exception;

import com.ss.challenge.ssr.application.core.domain.exception.BusinessRuntimeException;

public class OrderValidationNotFoundException extends BusinessRuntimeException {

    private static final String ORDER_VALIDATION_NOT_FOUND_ERROR_MESSAGE = "Order Validation not found.";

    public OrderValidationNotFoundException() {
        super(ORDER_VALIDATION_NOT_FOUND_ERROR_MESSAGE);
    }
    public OrderValidationNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

