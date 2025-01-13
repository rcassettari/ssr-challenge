package com.ss.challenge.ssr.adapters.out.ordervalidation.mapper;

import com.ss.challenge.ssr.adapters.out.ordervalidation.repository.entity.OrderValidationEntity;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderValidationEntityMapper {

    @Mapping(target = "streetType", source = "address.streetType")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "state", source = "address.state")
    @Mapping(target = "cep", source = "address.cep" )
    OrderValidationEntity toOrderValidationEntity(OrderValidation orderValidation);

    @Mapping(target = "address.streetType", source = "streetType")
    @Mapping(target = "address.street", source = "street")
    @Mapping(target = "address.city", source = "city")
    @Mapping(target = "address.state", source = "state")
    @Mapping(target = "address.cep", source = "cep")
    OrderValidation toOrderValidation(OrderValidationEntity orderValidationEntity);

}
