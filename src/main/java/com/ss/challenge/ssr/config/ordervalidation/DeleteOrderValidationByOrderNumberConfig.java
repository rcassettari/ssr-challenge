package com.ss.challenge.ssr.config.ordervalidation;

import com.ss.challenge.ssr.adapters.out.ordervalidation.DeleteOrderValidationByOrderNumberAdapter;
import com.ss.challenge.ssr.application.core.usecase.ordervalidation.DeleteOrderValidationByOrderNumberUseCase;
import com.ss.challenge.ssr.application.ports.out.ordervalidation.FindOrderValidationByOrderNumberOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteOrderValidationByOrderNumberConfig {

    @Bean
    public DeleteOrderValidationByOrderNumberUseCase deleteOrderValidationByOrderNumberUseCase (
            FindOrderValidationByOrderNumberOutputPort findOrderValidationByOrderNumberOutputPort,
            DeleteOrderValidationByOrderNumberAdapter deleteOrderValidationByOrderNumberAdapter
    ) {
        return new DeleteOrderValidationByOrderNumberUseCase(findOrderValidationByOrderNumberOutputPort, deleteOrderValidationByOrderNumberAdapter);
    }
}
