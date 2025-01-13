package com.ss.challenge.ssr.application.core.domain.ordervalidation.status;

public enum OrderValidationStatus {
    PENDING(0),
    APPROVED(1),
    REJECTED(2);

    private final int value;

    OrderValidationStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static OrderValidationStatus fromValue(int value) {
        for (OrderValidationStatus status : OrderValidationStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Order Validation Status value: " + value);
    }
}