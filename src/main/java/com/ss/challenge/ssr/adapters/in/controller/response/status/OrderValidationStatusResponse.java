package com.ss.challenge.ssr.adapters.in.controller.response.status;

public enum OrderValidationStatusResponse {

    PENDING(0),
    APPROVED(1),
    REJECTED(2);

    private final int value;

    OrderValidationStatusResponse(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static OrderValidationStatusResponse fromValue(int value) {
        for (OrderValidationStatusResponse status : OrderValidationStatusResponse.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid OrderValidationStatusResponse value: " + value);
    }
}
