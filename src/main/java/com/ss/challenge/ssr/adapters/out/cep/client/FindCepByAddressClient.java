package com.ss.challenge.ssr.adapters.out.cep.client;

import com.ss.challenge.ssr.adapters.out.cep.client.config.FindCepByAddressClientConfig;
import com.ss.challenge.ssr.adapters.out.cep.client.request.AddressRequest;
import com.ss.challenge.ssr.adapters.out.cep.client.response.CepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "FindCepByAddressClient",
    url = "${externalservices.cepbyaddressapi.client.address.url}",
    configuration = FindCepByAddressClientConfig.class
)
public interface FindCepByAddressClient {

    @PostMapping
    CepResponse find(@RequestBody AddressRequest address);

}
