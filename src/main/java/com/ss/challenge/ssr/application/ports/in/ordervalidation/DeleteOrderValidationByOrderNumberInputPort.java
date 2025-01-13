package com.ss.challenge.ssr.application.ports.in.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.ApprovedOrderValidationCannotBeDeletedException;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.OrderValidationNotFoundException;

public interface DeleteOrderValidationByOrderNumberInputPort {

    void delete(String orderNumber) throws OrderValidationNotFoundException, ApprovedOrderValidationCannotBeDeletedException;

}
