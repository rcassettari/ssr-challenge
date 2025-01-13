package com.ss.challenge.ssr.application.ports.out.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;

import java.util.Optional;

public interface FindOrderValidationByOrderNumberOutputPort {

    Optional<OrderValidation> find(String orderNumber);

}
