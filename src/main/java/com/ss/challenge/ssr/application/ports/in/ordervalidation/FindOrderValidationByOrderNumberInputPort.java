package com.ss.challenge.ssr.application.ports.in.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;

public interface FindOrderValidationByOrderNumberInputPort {

    OrderValidation find(String orderNumber);
}
