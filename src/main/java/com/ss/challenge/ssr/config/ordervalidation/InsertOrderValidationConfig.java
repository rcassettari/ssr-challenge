package com.ss.challenge.ssr.config.ordervalidation;

import com.ss.challenge.ssr.adapters.out.cep.FindCepByAddressAdapter;
import com.ss.challenge.ssr.adapters.out.ordervalidation.FindOrderValidationByOrderNumberAdapter;
import com.ss.challenge.ssr.adapters.out.ordervalidation.InsertOrderValidationAdapter;
import com.ss.challenge.ssr.application.core.usecase.ordervalidation.InsertOrderValidationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertOrderValidationConfig {

    @Bean
    public InsertOrderValidationUseCase insertOrderValidationUseCase(
            InsertOrderValidationAdapter insertOrderValidationAdapter,
            FindOrderValidationByOrderNumberAdapter findOrderValidationByOrderNumberAdapter,
            FindCepByAddressAdapter findCepByAddressAdapter
    ) {
        return new InsertOrderValidationUseCase(insertOrderValidationAdapter, findOrderValidationByOrderNumberAdapter , findCepByAddressAdapter);
    }
}
