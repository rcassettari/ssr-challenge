package com.ss.challenge.ssr.application.core.usecase.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.exception.OrderValidationAlreadyExistException;
import com.ss.challenge.ssr.application.core.usecase.helper.CepAndStatusHelper;
import com.ss.challenge.ssr.application.ports.in.ordervalidation.InsertOrderValidationInputPort;
import com.ss.challenge.ssr.application.ports.out.cep.FindCepByAddressOutputPort;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.FindOrderValidationByOrderNumberOutputPort;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.InsertOrderValidationOutputPort;

public class InsertOrderValidationUseCase implements InsertOrderValidationInputPort {

    private final InsertOrderValidationOutputPort insertOrderValidationOutputPort;

    private final FindOrderValidationByOrderNumberOutputPort findOrderValidationByOrderNumberOutputPort;
    private final FindCepByAddressOutputPort findCepByAddressOutputPort;

    public InsertOrderValidationUseCase(
            InsertOrderValidationOutputPort insertOrderValidationOutputPort,
            FindOrderValidationByOrderNumberOutputPort findOrderValidationByOrderNumberOutputPort,
            FindCepByAddressOutputPort findCepByAddressOutputPort
    ) {
        this.insertOrderValidationOutputPort = insertOrderValidationOutputPort;
        this.findOrderValidationByOrderNumberOutputPort = findOrderValidationByOrderNumberOutputPort;
        this.findCepByAddressOutputPort = findCepByAddressOutputPort;
    }

    @Override
    public void insert(OrderValidation orderValidation) throws OrderValidationAlreadyExistException {
        checkIfOrderValidationExists(orderValidation);
        CepAndStatusHelper.processCepAndStatus(findCepByAddressOutputPort, orderValidation);
        insertOrderValidationOutputPort.insert(orderValidation);
    }

    private void checkIfOrderValidationExists(OrderValidation orderValidation) throws OrderValidationAlreadyExistException {
        findOrderValidationByOrderNumberOutputPort.find(orderValidation.getOrderNumber())
                .ifPresent(order -> { throw new OrderValidationAlreadyExistException(); });
    }
}
