package com.ss.challenge.ssr.adapters.out.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import com.ss.challenge.ssr.adapters.out.ordervalidation.repository.OrderValidationRepository;
import com.ss.challenge.ssr.adapters.out.ordervalidation.mapper.OrderValidationEntityMapper;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.FindOrderValidationByOrderNumberOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindOrderValidationByOrderNumberAdapter implements FindOrderValidationByOrderNumberOutputPort {

    private final OrderValidationRepository orderValidationRepository;

    private final OrderValidationEntityMapper orderValidationEntityMapper;

    @Override
    public Optional<OrderValidation> find(String orderNumber) {
        return orderValidationRepository.findById(orderNumber)
                .map(orderValidationEntityMapper::toOrderValidation);
    }
}
