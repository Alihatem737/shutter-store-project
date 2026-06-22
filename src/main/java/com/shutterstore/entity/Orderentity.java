package com.shutterstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


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


    @ManyToOne
    @JoinColumn(name = "user_id")
    private Userentity user;


    //أي عملية تتم على Order طبقها أيضًا على الـ OrderItems المرتبطين به
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItementity> items;


}
