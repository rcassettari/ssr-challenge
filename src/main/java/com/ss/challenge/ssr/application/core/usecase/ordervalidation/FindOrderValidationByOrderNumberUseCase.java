package com.ss.challenge.ssr.application.core.usecase.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.OrderValidationNotFoundException;
import com.ss.challenge.ssr.application.ports.in.ordervalidation.FindOrderValidationByOrderNumberInputPort;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.FindOrderValidationByOrderNumberOutputPort;

public class FindOrderValidationByOrderNumberUseCase implements FindOrderValidationByOrderNumberInputPort  {

    private final FindOrderValidationByOrderNumberOutputPort findOrderValidationByOrderNumberOutputPort;

    public FindOrderValidationByOrderNumberUseCase(FindOrderValidationByOrderNumberOutputPort findOrderValidationByOrderNumberOutputPort) {
        this.findOrderValidationByOrderNumberOutputPort = findOrderValidationByOrderNumberOutputPort;
    }

    @Override
    public OrderValidation find(String orderNumber) {
        return findOrderValidationByOrderNumberOutputPort.find(orderNumber)
                .orElseThrow(OrderValidationNotFoundException::new);
    }
}
