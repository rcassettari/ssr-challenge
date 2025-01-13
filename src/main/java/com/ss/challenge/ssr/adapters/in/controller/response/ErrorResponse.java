package com.ss.challenge.ssr.adapters.in.controller.response;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = -8381076278016077024L;

    private Integer status;
    private String errorMessage;
    private Instant timestamp;
}