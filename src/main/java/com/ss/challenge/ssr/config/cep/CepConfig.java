package com.ss.challenge.ssr.config.cep;

import com.ss.challenge.ssr.adapters.out.cep.CepQueryLogAdapter;
import com.ss.challenge.ssr.application.core.usecase.cep.InsertCepQueryLogUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CepConfig {
    @Bean
    public InsertCepQueryLogUseCase insertCepQueryLogUseCase (
            CepQueryLogAdapter cepQueryLogAdapter
    ) {
        return new InsertCepQueryLogUseCase(cepQueryLogAdapter);
    }
}
