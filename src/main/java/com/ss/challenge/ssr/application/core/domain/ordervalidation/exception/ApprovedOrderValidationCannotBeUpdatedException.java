package com.ss.challenge.ssr.application.core.domain.ordervalidation.exception;

import com.ss.challenge.ssr.application.core.domain.exception.BusinessRuntimeException;

public class ApprovedOrderValidationCannotBeUpdatedException extends BusinessRuntimeException {

    private static final String ORDER_VALIDATION_CANNOT_BE_UPDATED_ERROR_MESSAGE = "Approved order validation cannot be updated.";

    public ApprovedOrderValidationCannotBeUpdatedException() {
        super(ORDER_VALIDATION_CANNOT_BE_UPDATED_ERROR_MESSAGE);
    }
    public ApprovedOrderValidationCannotBeUpdatedException(String errorMessage) {
        super(errorMessage);
    }
}

