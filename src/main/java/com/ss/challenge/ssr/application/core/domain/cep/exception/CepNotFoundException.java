package com.ss.challenge.ssr.application.core.domain.cep.exception;

import com.ss.challenge.ssr.application.core.domain.exception.BusinessRuntimeException;

public class CepNotFoundException extends BusinessRuntimeException {
    private int httpStatus;

    private static final String CEP_NOT_FOUND_ERROR_MESSAGE = "Cep not found.";

    public CepNotFoundException() {
        super(CEP_NOT_FOUND_ERROR_MESSAGE);
    }
    public CepNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public CepNotFoundException(int httpStatus) {
        super(CEP_NOT_FOUND_ERROR_MESSAGE);
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}

