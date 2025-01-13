package com.ss.challenge.ssr.adapters.out.address.mapper;

import com.ss.challenge.ssr.application.core.domain.address.Address;
import com.ss.challenge.ssr.adapters.out.cep.client.request.AddressRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressRequest toAddressRequest(Address address);

}
