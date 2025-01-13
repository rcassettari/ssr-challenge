package com.ss.challenge.ssr.application.ports.out.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;

public interface UpdateOrderValidationOutputPort {

    void update(OrderValidation orderValidation);

}
