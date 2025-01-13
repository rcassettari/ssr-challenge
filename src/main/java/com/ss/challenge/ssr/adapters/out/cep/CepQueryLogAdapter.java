package com.ss.challenge.ssr.adapters.out.cep;

import com.ss.challenge.ssr.adapters.out.cep.mapper.CepMapper;
import com.ss.challenge.ssr.adapters.out.cep.repository.CepQueryLogRepository;
import com.ss.challenge.ssr.application.core.domain.cep.CepQueryLog;
import com.ss.challenge.ssr.application.ports.out.cep.CepQueryLogOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CepQueryLogAdapter implements CepQueryLogOutputPort {
    private final CepMapper cepMapper;

    private final CepQueryLogRepository cepQueryLogRepository;

    @Override
    public void save(CepQueryLog cepQueryLog) {
        var cepQueryLogEntity = cepMapper.toCepQueryLogEntity(cepQueryLog);
        cepQueryLogRepository.save(cepQueryLogEntity);
    }
}