package com.ss.challenge.ssr.adapters.out.cep.client.interceptor;

import com.ss.challenge.ssr.adapters.out.cep.client.exception.FeignClientException;
import com.ss.challenge.ssr.adapters.out.cep.client.request.AddressRequest;
import com.ss.challenge.ssr.adapters.out.cep.client.response.CepResponse;
import com.ss.challenge.ssr.application.core.domain.cep.exception.CepNotFoundException;
import com.ss.challenge.ssr.application.core.domain.cep.CepQueryLog;
import com.ss.challenge.ssr.application.ports.in.cep.CepQueryLogInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class FindCepByAddressClientInterceptor {

    private final CepQueryLogInputPort cepQueryLogInputPort;

    @Around("execution(* com.ss.challenge.ssr.adapters.out.cep.client.FindCepByAddressClient.find(..))")
    public Object interceptFeignClientCall(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Intercepting call to Feign client: {}", joinPoint.getSignature().toShortString());
        Object[] args = joinPoint.getArgs();
        CepQueryLog logEntry = new CepQueryLog();

        if (args.length > 0) {
            log.info("Request payload: {}", args[0]);
            AddressRequest addressRequest = (AddressRequest) args[0];
            setRequestLogInputData(logEntry, addressRequest);
        } else {
            log.info("Request payload: {}", "No payload");
        }

        try {
            Object result = joinPoint.proceed();
            log.info("Response received: {}", result);
            CepResponse cepResponse = (CepResponse) result;
            setRequestLogOutputData(logEntry, cepResponse, HttpStatus.OK.value());
            cepQueryLogInputPort.logQuery(logEntry);
            return result;
        } catch (CepNotFoundException cepNotFoundException) {
            log.info("Response received: CepNotFoundException");
            logEntry.setOutputHttpStatus(cepNotFoundException.getHttpStatus());
            cepQueryLogInputPort.logQuery(logEntry);
            throw cepNotFoundException;
        } catch (FeignClientException feignClientException) {
            log.info("Response Exception - feignClientException: {}", feignClientException.getMessage());
            logEntry.setOutputHttpStatus(feignClientException.getHttpStatus());
            cepQueryLogInputPort.logQuery(logEntry);
            throw feignClientException;
        } catch (Throwable ex) {
            log.info("Error occurred during Feign client call", ex);
            logEntry.setOutputHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            cepQueryLogInputPort.logQuery(logEntry);
            throw ex;
        }
    }

    private void setRequestLogInputData(CepQueryLog logEntry, AddressRequest addressRequest) {
        logEntry.setInputStreetType(addressRequest.getStreetType());
        logEntry.setInputStreet(addressRequest.getStreet());
        logEntry.setInputCity(addressRequest.getCity());
        logEntry.setInputState(addressRequest.getState());
        logEntry.setQueryDateTime(LocalDateTime.now());
    }

    private void setRequestLogOutputData(CepQueryLog logEntry, CepResponse cepResponse, int httpStatus) {
        logEntry.setOutputCep(cepResponse.getCep());
        logEntry.setOutputHttpStatus(httpStatus);
    }
}
