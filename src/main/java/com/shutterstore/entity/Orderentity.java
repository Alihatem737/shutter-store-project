package com.shutterstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Table(name = "orders")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orderentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "totalprice")
    private BigDecimal totalprice;


    @Column(name = "status")
    private String status;

    @Column(name = "shippingaddress")
    private String shippingaddress;

    @Column(name = "createdat")
    private LocalDateTime createdat;


}
