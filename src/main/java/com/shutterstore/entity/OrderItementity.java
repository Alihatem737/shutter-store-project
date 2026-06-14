package com.shutterstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "orderitem")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItementity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;


    @Column(name = "unitprice")
    private BigDecimal unitprice;





}
