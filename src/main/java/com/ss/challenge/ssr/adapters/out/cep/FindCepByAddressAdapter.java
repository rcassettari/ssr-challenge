package com.ss.challenge.ssr.adapters.out.cep;

import com.ss.challenge.ssr.application.core.domain.address.Address;
import com.ss.challenge.ssr.application.core.domain.cep.Cep;
import com.ss.challenge.ssr.adapters.out.address.mapper.AddressMapper;
import com.ss.challenge.ssr.adapters.out.cep.client.FindCepByAddressClient;
import com.ss.challenge.ssr.adapters.out.cep.mapper.CepMapper;
import com.ss.challenge.ssr.application.ports.out.cep.FindCepByAddressOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindCepByAddressAdapter implements FindCepByAddressOutputPort {

    private final FindCepByAddressClient findCepByAddressClient;

    private final AddressMapper addressMapper;

    private final CepMapper cepMapper;

    @Override
    public Cep find(Address address) {
        var addressRequest = addressMapper.toAddressRequest(address);
        var cepResponse = findCepByAddressClient.find(addressRequest);
        return cepMapper.toCep(cepResponse);
    }
}


