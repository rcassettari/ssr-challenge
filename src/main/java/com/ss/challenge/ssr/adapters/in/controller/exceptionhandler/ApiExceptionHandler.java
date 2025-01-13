package com.ss.challenge.ssr.adapters.in.controller.exceptionhandler;

import com.ss.challenge.ssr.adapters.in.controller.response.ErrorResponse;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.ApprovedOrderValidationCannotBeUpdatedException;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.OrderValidationAlreadyExistException;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.OrderValidationNotFoundException;
import com.ss.challenge.ssr.adapters.out.cep.client.exception.FeignClientException;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.ApprovedOrderValidationCannotBeDeletedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    private static final Map<Class<? extends Exception>, HttpStatus> exceptionStatusMap = new HashMap<>();

    static {
        exceptionStatusMap.put(OrderValidationNotFoundException.class, HttpStatus.NOT_FOUND);
        exceptionStatusMap.put(ApprovedOrderValidationCannotBeUpdatedException.class, HttpStatus.BAD_REQUEST);
        exceptionStatusMap.put(OrderValidationAlreadyExistException.class, HttpStatus.BAD_REQUEST);
        exceptionStatusMap.put(ApprovedOrderValidationCannotBeDeletedException.class, HttpStatus.BAD_REQUEST);
        exceptionStatusMap.put(FeignClientException.class, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        HttpStatus httpStatus = exceptionStatusMap.getOrDefault(ex.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        ErrorResponse error = buildErrorResponse(ex, httpStatus);
        return new ResponseEntity<>(error, httpStatus);
    }

    private ErrorResponse buildErrorResponse(Exception ex, HttpStatus httpStatus) {
        return ErrorResponse.builder()
                .status(httpStatus.value())
                .timestamp(Instant.now())
                .errorMessage(ex.getMessage())
                .build();
    }
}

