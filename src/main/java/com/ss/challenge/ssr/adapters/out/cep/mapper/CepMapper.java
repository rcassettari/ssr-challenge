package com.ss.challenge.ssr.adapters.out.cep.mapper;

import com.ss.challenge.ssr.adapters.out.cep.client.response.CepResponse;
import com.ss.challenge.ssr.application.core.domain.cep.Cep;
import com.ss.challenge.ssr.adapters.out.cep.repository.entity.CepQueryLogEntity;
import com.ss.challenge.ssr.application.core.domain.cep.CepQueryLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CepMapper {

    Cep toCep(CepResponse cepResponse);

    @Mapping(target = "id", ignore = true)
    CepQueryLogEntity toCepQueryLogEntity(CepQueryLog cepQueryLog);
}
