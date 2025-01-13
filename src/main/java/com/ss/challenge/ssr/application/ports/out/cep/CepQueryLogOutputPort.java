package com.ss.challenge.ssr.application.ports.out.cep;

import com.ss.challenge.ssr.application.core.domain.cep.CepQueryLog;

public interface CepQueryLogOutputPort {
    void save(CepQueryLog cepQueryLog);
}
