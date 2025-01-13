package com.ss.challenge.ssr.adapters.out.cep.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cep_query_log")
@Data
public class CepQueryLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "input_street_type", nullable = false)
    private String inputStreetType;

    @Column(nullable = false)
    private String inputStreet;

    @Column(nullable = false)
    private String inputCity;

    @Column(nullable = false)
    private String inputState;

    @Column(name = "output_cep", nullable = true)
    private String outputCep;

    @Column(name = "output_http_status", nullable = false)
    private Integer outputHttpStatus;

    @Column(name = "query_datetime", nullable = false)
    private LocalDateTime queryDateTime;
}