package com.ss.challenge.ssr.application.ports.out.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;

public interface InsertOrderValidationOutputPort {

    void insert(OrderValidation orderValidation);

}
