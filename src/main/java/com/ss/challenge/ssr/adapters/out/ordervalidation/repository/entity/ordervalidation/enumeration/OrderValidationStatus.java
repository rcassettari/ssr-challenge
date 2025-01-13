package com.ss.challenge.ssr.adapters.out.ordervalidation.repository.entity.ordervalidation.enumeration;

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

    public static com.ss.challenge.ssr.application.core.domain.ordervalidation.status.OrderValidationStatus fromValue(int value) {
        for (com.ss.challenge.ssr.application.core.domain.ordervalidation.status.OrderValidationStatus status : com.ss.challenge.ssr.application.core.domain.ordervalidation.status.OrderValidationStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid OrderValidationStatus value: " + value);
    }
}