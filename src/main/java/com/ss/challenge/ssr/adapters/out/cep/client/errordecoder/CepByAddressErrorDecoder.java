package com.ss.challenge.ssr.adapters.out.cep.client.errordecoder;

import com.ss.challenge.ssr.application.core.domain.cep.exception.CepNotFoundException;
import com.ss.challenge.ssr.adapters.out.cep.client.exception.FeignClientException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CepByAddressErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String message = String.format("Error %d while calling %s", response.status(), methodKey);

        switch (response.status()) {
            case 404:
                return new CepNotFoundException(response.status());
            default:
                return new FeignClientException(message, response.status());
        }
    }
}