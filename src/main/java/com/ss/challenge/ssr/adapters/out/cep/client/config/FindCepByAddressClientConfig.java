package com.ss.challenge.ssr.adapters.out.cep.client.config;

import com.ss.challenge.ssr.adapters.out.cep.client.errordecoder.CepByAddressErrorDecoder;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FindCepByAddressClientConfig {

    @Bean
    public ErrorDecoder cepByAddressErrorDecoder() {
        return new CepByAddressErrorDecoder();
    }
}
