package com.ss.challenge.ssr.adapters.out.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import com.ss.challenge.ssr.adapters.out.ordervalidation.repository.OrderValidationRepository;
import com.ss.challenge.ssr.adapters.out.ordervalidation.mapper.OrderValidationEntityMapper;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.InsertOrderValidationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertOrderValidationAdapter implements InsertOrderValidationOutputPort {

    private final OrderValidationRepository orderValidationRepository;

    private final OrderValidationEntityMapper orderValidationEntityMapper;

    @Override
    public void insert(OrderValidation orderValidation) {
        var orderValidationEntity = orderValidationEntityMapper.toOrderValidationEntity(orderValidation);
        orderValidationRepository.save(orderValidationEntity);
    }
}
