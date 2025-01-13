package com.ss.challenge.ssr.config.ordervalidation;

import com.ss.challenge.ssr.adapters.out.cep.FindCepByAddressAdapter;
import com.ss.challenge.ssr.application.core.usecase.ordervalidation.UpdateOrderValidationUseCase;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.FindOrderValidationByOrderNumberOutputPort;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.UpdateOrderValidationOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateOrderValidationConfig {

    @Bean
    public UpdateOrderValidationUseCase updateOrderValidationUseCase(
            FindOrderValidationByOrderNumberOutputPort findOrderValidationByOrderNumberOutputPort,
            UpdateOrderValidationOutputPort updateOrderValidationOutputPort,
            FindCepByAddressAdapter findCepByAddressAdapter
    ) {
        return new UpdateOrderValidationUseCase(findOrderValidationByOrderNumberOutputPort, updateOrderValidationOutputPort, findCepByAddressAdapter);
    }
}
