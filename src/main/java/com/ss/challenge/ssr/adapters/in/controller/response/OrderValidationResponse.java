package com.ss.challenge.ssr.adapters.in.controller.response;

import com.ss.challenge.ssr.adapters.in.controller.response.status.OrderValidationStatusResponse;
import lombok.Data;

@Data
public class OrderValidationResponse {
    private String orderNumber;
    private String email;
    private AddressResponse addressResponse;
    private OrderValidationStatusResponse status;

}
