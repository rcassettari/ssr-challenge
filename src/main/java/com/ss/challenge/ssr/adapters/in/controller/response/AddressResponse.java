package com.ss.challenge.ssr.adapters.in.controller.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String streetType;

    private String street;

    private String city;

    private String state;

    private String cep;
}
