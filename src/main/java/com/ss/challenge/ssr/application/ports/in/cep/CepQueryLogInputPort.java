package com.ss.challenge.ssr.application.ports.in.cep;

import com.ss.challenge.ssr.application.core.domain.cep.CepQueryLog;

public interface CepQueryLogInputPort {
    void logQuery(CepQueryLog cepQueryLog);
}

