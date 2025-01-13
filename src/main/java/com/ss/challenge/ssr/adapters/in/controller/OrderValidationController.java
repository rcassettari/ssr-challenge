package com.ss.challenge.ssr.adapters.in.controller;

import com.ss.challenge.ssr.adapters.in.controller.mapper.OrderValidationMapper;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.OrderValidation;
import com.ss.challenge.ssr.application.ports.in.ordervalidation.InsertOrderValidationInputPort;
import com.ss.challenge.ssr.adapters.in.controller.request.OrderValidationRequest;
import com.ss.challenge.ssr.adapters.in.controller.response.OrderValidationResponse;

import com.ss.challenge.ssr.application.ports.in.ordervalidation.DeleteOrderValidationByOrderNumberInputPort;
import com.ss.challenge.ssr.application.ports.in.ordervalidation.FindOrderValidationByOrderNumberInputPort;
import com.ss.challenge.ssr.application.ports.in.ordervalidation.UpdateOrderValidationInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/ordervalidation")
@RequiredArgsConstructor
public class OrderValidationController implements OrderValidationContract{

    private final InsertOrderValidationInputPort insertOrderValidationInputPort;

    private final FindOrderValidationByOrderNumberInputPort findOrderValidationByOrderNumberInputPort;

    private final UpdateOrderValidationInputPort updateOrderValidationInputPort;

    private final DeleteOrderValidationByOrderNumberInputPort deleteOrderValidationByOrderNumberInputPort;

    private final OrderValidationMapper orderValidationMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody OrderValidationRequest orderValidationRequest) {
        var orderValidation = orderValidationMapper.toOrderValidation(orderValidationRequest);
        insertOrderValidationInputPort.insert(orderValidation);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderNumber}")
    public ResponseEntity<OrderValidationResponse> findByOrderNumber(@PathVariable final String orderNumber) {
        var orderValidation = findOrderValidationByOrderNumberInputPort.find(orderNumber);
        var orderValidationResponse = orderValidationMapper.toOrderValidationResponse(orderValidation);
        return ResponseEntity.ok().body(orderValidationResponse);
    }

    @PutMapping("/{orderNumber}")
    public ResponseEntity<Void> updateByOrderNumber(@PathVariable final String orderNumber, @Valid @RequestBody OrderValidationRequest orderValidationRequest) {
        OrderValidation orderValidation = orderValidationMapper.toOrderValidation(orderValidationRequest);
        orderValidation.setOrderNumber(orderNumber);
        updateOrderValidationInputPort.update(orderValidation);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{orderNumber}")
    public ResponseEntity<Void> deleteByOrderNumber(@PathVariable final String orderNumber) {
        deleteOrderValidationByOrderNumberInputPort.delete(orderNumber);
        return ResponseEntity.noContent().build();
    }

}
