package com.ss.challenge.ssr.application.core.domain.cep;

import java.time.LocalDateTime;

public class CepQueryLog {

    private Long id;

    private String inputStreetType;

    private String inputStreet;

    private String inputCity;

    private String inputState;

    private String outputCep;

    private Integer outputHttpStatus;

    private LocalDateTime queryDateTime;

    public CepQueryLog() {

    }

    public CepQueryLog(Long id, String inputStreetType, String inputStreet, String inputCity, String inputState, String outputCep, Integer outputHttpStatus, LocalDateTime queryDateTime) {
        this.id = id;
        this.inputStreetType = inputStreetType;
        this.inputStreet = inputStreet;
        this.inputCity = inputCity;
        this.inputState = inputState;
        this.outputCep = outputCep;
        this.outputHttpStatus = outputHttpStatus;
        this.queryDateTime = queryDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInputStreetType() {
        return inputStreetType;
    }

    public void setInputStreetType(String inputStreetType) {
        this.inputStreetType = inputStreetType;
    }

    public String getInputStreet() {
        return inputStreet;
    }

    public void setInputStreet(String inputStreet) {
        this.inputStreet = inputStreet;
    }

    public String getInputCity() {
        return inputCity;
    }

    public void setInputCity(String inputCity) {
        this.inputCity = inputCity;
    }

    public String getInputState() {
        return inputState;
    }

    public void setInputState(String inputState) {
        this.inputState = inputState;
    }

    public String getOutputCep() {
        return outputCep;
    }

    public void setOutputCep(String outputCep) {
        this.outputCep = outputCep;
    }

    public Integer getOutputHttpStatus() {
        return outputHttpStatus;
    }

    public void setOutputHttpStatus(Integer outputHttpStatus) {
        this.outputHttpStatus = outputHttpStatus;
    }

    public LocalDateTime getQueryDateTime() {
        return queryDateTime;
    }

    public void setQueryDateTime(LocalDateTime queryDateTime) {
        this.queryDateTime = queryDateTime;
    }
}
