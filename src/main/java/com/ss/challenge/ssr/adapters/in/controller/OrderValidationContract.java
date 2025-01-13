package com.ss.challenge.ssr.adapters.in.controller;

import com.ss.challenge.ssr.adapters.in.controller.request.OrderValidationRequest;
import com.ss.challenge.ssr.adapters.in.controller.response.OrderValidationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface OrderValidationContract {
    ResponseEntity<Void> insert(@Valid @RequestBody OrderValidationRequest orderValidationRequest);
    ResponseEntity<OrderValidationResponse> findByOrderNumber(@PathVariable final String orderNumber);
    ResponseEntity<Void> updateByOrderNumber(@PathVariable final String orderNumber, @Valid @RequestBody OrderValidationRequest orderValidationRequest);
    ResponseEntity<Void> deleteByOrderNumber(@PathVariable final String orderNumber);
}
