package com.ss.challenge.ssr.adapters.out.cep.client.exception;

public class FeignClientException extends RuntimeException {
    private final int httpStatus;

    public FeignClientException(String message, int httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}