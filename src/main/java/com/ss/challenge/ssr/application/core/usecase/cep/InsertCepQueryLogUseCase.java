package com.ss.challenge.ssr.application.core.usecase.cep;

import com.ss.challenge.ssr.application.core.domain.cep.CepQueryLog;
import com.ss.challenge.ssr.application.ports.in.cep.CepQueryLogInputPort;
import com.ss.challenge.ssr.application.ports.out.cep.CepQueryLogOutputPort;

public class InsertCepQueryLogUseCase implements CepQueryLogInputPort {

    private final CepQueryLogOutputPort cepQueryLogOutputPort;

    public InsertCepQueryLogUseCase(
            CepQueryLogOutputPort cepQueryLogOutputPort
    ) {
        this.cepQueryLogOutputPort = cepQueryLogOutputPort;
    }

    @Override
    public void logQuery(CepQueryLog cepQueryLog) {
        cepQueryLogOutputPort.save(cepQueryLog);
    }
}

