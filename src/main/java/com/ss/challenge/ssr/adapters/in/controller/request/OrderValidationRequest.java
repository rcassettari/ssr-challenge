package com.ss.challenge.ssr.adapters.in.controller.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class OrderValidationRequest {
    @NotBlank
    @Size(min = 1, max = 255)
    private String orderNumber;
    @NotBlank
    @Email
    @Size(min = 6, max = 255)
    private String email;
    @NotBlank
    @Size(min = 3, max = 50)
    private String streetType;
    @NotBlank
    @Size(min = 1, max = 255)
    private String street;
    @NotBlank
    @Size(min = 1, max = 255)
    private String city;
    @NotBlank
    @Size(min = 2, max = 2)
    private String state;
}
