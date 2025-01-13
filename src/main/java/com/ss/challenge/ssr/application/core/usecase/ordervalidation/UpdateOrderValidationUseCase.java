package com.ss.challenge.ssr.application.core.usecase.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.ApprovedOrderValidationCannotBeUpdatedException;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.status.OrderValidationStatus;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.OrderValidationNotFoundException;
import com.ss.challenge.ssr.application.core.usecase.helper.CepAndStatusHelper;
import com.ss.challenge.ssr.application.ports.in.ordervalidation.UpdateOrderValidationInputPort;
import com.ss.challenge.ssr.application.ports.out.cep.FindCepByAddressOutputPort;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.FindOrderValidationByOrderNumberOutputPort;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.UpdateOrderValidationOutputPort;

import java.util.Optional;

public class UpdateOrderValidationUseCase implements UpdateOrderValidationInputPort {

    private final FindOrderValidationByOrderNumberOutputPort findOrderValidationByOrderNumberOutputPort;

    private final UpdateOrderValidationOutputPort updateOrderValidationOutputPort;

    private final FindCepByAddressOutputPort findCepByAddressOutputPort;

    public UpdateOrderValidationUseCase(
            FindOrderValidationByOrderNumberOutputPort findOrderValidationByOrderNumberOutputPort,
            UpdateOrderValidationOutputPort updateOrderValidationOutputPort,
            FindCepByAddressOutputPort findCepByAddressOutputPort
    ) {
        this.findOrderValidationByOrderNumberOutputPort = findOrderValidationByOrderNumberOutputPort;
        this.updateOrderValidationOutputPort = updateOrderValidationOutputPort;
        this.findCepByAddressOutputPort = findCepByAddressOutputPort;
    }

    @Override
    public void update(OrderValidation orderValidation) throws OrderValidationNotFoundException, ApprovedOrderValidationCannotBeUpdatedException {
        var searchedOrderValidation = findOrderValidationByOrderNumberOutputPort.find(orderValidation.getOrderNumber())
                                                                                .orElseThrow(OrderValidationNotFoundException::new);
        validateOrderUpdate(searchedOrderValidation);
        CepAndStatusHelper.processCepAndStatus(findCepByAddressOutputPort, orderValidation);
        updateOrderValidationOutputPort.update(orderValidation);
    }

    private void validateOrderUpdate(OrderValidation searchedOrderValidation) {
        Optional.of(searchedOrderValidation).filter(order -> !OrderValidationStatus.APPROVED.equals(order.getStatus()))
                .orElseThrow(ApprovedOrderValidationCannotBeUpdatedException::new);
    }
}
