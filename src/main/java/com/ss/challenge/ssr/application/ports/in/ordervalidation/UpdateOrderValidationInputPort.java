package com.ss.challenge.ssr.application.ports.in.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.ApprovedOrderValidationCannotBeUpdatedException;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.OrderValidationNotFoundException;

public interface UpdateOrderValidationInputPort {

    void update(OrderValidation orderValidation) throws OrderValidationNotFoundException, ApprovedOrderValidationCannotBeUpdatedException;

}
