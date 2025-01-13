package com.ss.challenge.ssr.application.core.domain.ordervalidation;

import com.ss.challenge.ssr.application.core.domain.address.Address;
import com.ss.challenge.ssr.application.core.domain.ordervalidation.status.OrderValidationStatus;

public class OrderValidation {

    private String orderNumber;
    private String email;
    private Address address;
    private OrderValidationStatus status;

    public OrderValidation() {
        this.status = OrderValidationStatus.PENDING;
    }

    public OrderValidation(String orderNumber, String email, Address address, OrderValidationStatus orderValidationStatus) {
        this.orderNumber = orderNumber;
        this.email = email;
        this.address = address;
        this.status = orderValidationStatus;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OrderValidationStatus getStatus() {
        return status;
    }

    public void setStatus(OrderValidationStatus status) {
        this.status = status;
    }
}
