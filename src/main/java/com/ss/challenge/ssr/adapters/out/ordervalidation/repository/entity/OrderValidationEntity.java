package com.ss.challenge.ssr.adapters.out.ordervalidation.repository.entity;

import com.ss.challenge.ssr.adapters.out.ordervalidation.repository.entity.ordervalidation.enumeration.OrderValidationStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_validation")
@Data
public class OrderValidationEntity implements Serializable {

    @Id
    @Column(name = "order_number")
    private String orderNumber;

    @Column(nullable = false)
    private String email;

    @Column(name = "street_type", nullable = false)
    private String streetType;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = true)
    private String cep;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OrderValidationStatus status;
}
