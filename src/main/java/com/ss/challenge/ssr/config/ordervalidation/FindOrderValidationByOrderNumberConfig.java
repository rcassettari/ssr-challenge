package com.ss.challenge.ssr.config.ordervalidation;

import com.ss.challenge.ssr.adapters.out.ordervalidation.FindOrderValidationByOrderNumberAdapter;
import com.ss.challenge.ssr.application.core.usecase.ordervalidation.FindOrderValidationByOrderNumberUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderValidationByOrderNumberConfig {

    @Bean
    public FindOrderValidationByOrderNumberUseCase findOrderValidationByOrderNumberUseCase(
            FindOrderValidationByOrderNumberAdapter findOrderValidationByOrderNumberAdapter
    ) {
        return new FindOrderValidationByOrderNumberUseCase(findOrderValidationByOrderNumberAdapter);
    }
}
