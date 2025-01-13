package com.ss.challenge.ssr.application.ports.out.cep;

import com.ss.challenge.ssr.application.core.domain.address.Address;
import com.ss.challenge.ssr.application.core.domain.cep.Cep;

public interface FindCepByAddressOutputPort {

    Cep find(Address address);

}
