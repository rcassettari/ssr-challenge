package com.ss.challenge.ssr.adapters.out.ordervalidation;

import com.ss.challenge.ssr.adapters.out.ordervalidation.mapper.OrderValidationEntityMapper;
import com.ss.challenge.ssr.adapters.out.ordervalidation.repository.OrderValidationRepository;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.UpdateOrderValidationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateOrderValidationAdapter implements UpdateOrderValidationOutputPort {

    private final OrderValidationRepository orderValidationRepository;

    private final OrderValidationEntityMapper orderValidationEntityMapper;

    @Override
    public void update(OrderValidation orderValidation) {
        var orderValidationEntity = orderValidationEntityMapper.toOrderValidationEntity(orderValidation);
        orderValidationRepository.save(orderValidationEntity);
    }
}
