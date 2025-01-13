package com.ss.challenge.ssr.adapters.out.cep.client.request;

import lombok.Data;

@Data
public class AddressRequest {
    private String streetType;

    private String street;

    private String city;

    private String state;
}
