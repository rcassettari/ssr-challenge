package com.ss.challenge.ssr.adapters.out.ordervalidation;

import com.ss.challenge.ssr.adapters.out.ordervalidation.repository.OrderValidationRepository;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.DeleteOrderValidationByOrderNumberOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteOrderValidationByOrderNumberAdapter implements DeleteOrderValidationByOrderNumberOutputPort {

    private final OrderValidationRepository orderValidationStatusRepository;

    @Override
    public void delete(String orderNumber) {
        orderValidationStatusRepository.deleteById(orderNumber);
    }

}
