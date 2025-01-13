package com.ss.challenge.ssr.application.core.domain.ordervalidation.exception;

import com.ss.challenge.ssr.application.core.domain.exception.BusinessRuntimeException;

public class ApprovedOrderValidationCannotBeDeletedException extends BusinessRuntimeException {

    private static final String ORDER_VALIDATION_CANNOT_BE_DELETED_ERROR_MESSAGE = "Approved order validation cannot be deleted.";

    public ApprovedOrderValidationCannotBeDeletedException() {
        super(ORDER_VALIDATION_CANNOT_BE_DELETED_ERROR_MESSAGE);
    }
    public ApprovedOrderValidationCannotBeDeletedException(String errorMessage) {
        super(errorMessage);
    }
}

