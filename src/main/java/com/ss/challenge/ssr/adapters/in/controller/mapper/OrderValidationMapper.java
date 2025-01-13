package com.ss.challenge.ssr.adapters.in.controller.mapper;

import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import com.ss.challenge.ssr.adapters.in.controller.request.OrderValidationRequest;
import com.ss.challenge.ssr.adapters.in.controller.response.OrderValidationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderValidationMapper {

    @Mapping(target = "status", ignore = true)
    @Mapping(target = "address.streetType", source = "streetType")
    @Mapping(target = "address.street", source = "street")
    @Mapping(target = "address.city", source = "city")
    @Mapping(target = "address.state", source = "state")
    OrderValidation toOrderValidation(OrderValidationRequest orderValidationRequest);

    @Mapping(target = "addressResponse", source = "address")
    OrderValidationResponse toOrderValidationResponse(OrderValidation orderValidation);

}
