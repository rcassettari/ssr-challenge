package com.ss.challenge.ssr.application.core.usecase.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.ApprovedOrderValidationCannotBeDeletedException;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.OrderValidationNotFoundException;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.status.OrderValidationStatus;
import com.ss.challenge.ssr.application.ports.in.ordervalidation.DeleteOrderValidationByOrderNumberInputPort;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.DeleteOrderValidationByOrderNumberOutputPort;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.FindOrderValidationByOrderNumberOutputPort;

import java.util.Optional;

public class DeleteOrderValidationByOrderNumberUseCase implements DeleteOrderValidationByOrderNumberInputPort {

    private final FindOrderValidationByOrderNumberOutputPort findOrderValidationByOrderNumberOutputPort;
    private final DeleteOrderValidationByOrderNumberOutputPort deleteOrderValidationByOrderNumberOutputPort;

    public DeleteOrderValidationByOrderNumberUseCase(
            FindOrderValidationByOrderNumberOutputPort findOrderValidationByOrderNumberOutputPort,
            DeleteOrderValidationByOrderNumberOutputPort deleteOrderValidationByOrderNumberOutputPort
    ) {
        this.findOrderValidationByOrderNumberOutputPort = findOrderValidationByOrderNumberOutputPort;
        this.deleteOrderValidationByOrderNumberOutputPort = deleteOrderValidationByOrderNumberOutputPort;
    }

    @Override
    public void delete(final String orderNumber) throws OrderValidationNotFoundException, ApprovedOrderValidationCannotBeDeletedException {
        var searchedOrderValidation = findOrderValidationByOrderNumberOutputPort.find(orderNumber)
                                                                                .orElseThrow(OrderValidationNotFoundException::new);

        Optional.of(searchedOrderValidation).filter(order -> !OrderValidationStatus.APPROVED.equals(order.getStatus()))
                .orElseThrow(ApprovedOrderValidationCannotBeDeletedException::new);

        deleteOrderValidationByOrderNumberOutputPort.delete(orderNumber);
    }
}
