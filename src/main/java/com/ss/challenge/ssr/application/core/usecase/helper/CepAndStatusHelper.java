package com.ss.challenge.ssr.application.core.usecase.helper;

import com.ss.challenge.ssr.application.core.domain.cep.Cep;
import com.ss.challenge.ssr.application.core.domain.cep.exception.CepNotFoundException;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.status.OrderValidationStatus;
import com.ss.challenge.ssr.application.ports.out.cep.FindCepByAddressOutputPort;

public class CepAndStatusHelper {

    private CepAndStatusHelper() {
    }

    public static void processCepAndStatus(FindCepByAddressOutputPort findCepByAddressOutputPort, OrderValidation orderValidation) {
        try {
            Cep cep = findCepByAddressOutputPort.find(orderValidation.getAddress());
            orderValidation.getAddress().setCep(cep.getCep());
            orderValidation.setStatus(OrderValidationStatus.APPROVED);
        } catch (CepNotFoundException cepNotFoundException) {
            orderValidation.getAddress().setCep(null);
            orderValidation.setStatus(OrderValidationStatus.REJECTED);
        }
    }
}
