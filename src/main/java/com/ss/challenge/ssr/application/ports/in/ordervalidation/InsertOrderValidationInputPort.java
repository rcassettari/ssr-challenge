package com.ss.challenge.ssr.application.ports.in.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.OrderValidationAlreadyExistException;

public interface InsertOrderValidationInputPort {

    void insert(OrderValidation orderValidation) throws OrderValidationAlreadyExistException;

}
