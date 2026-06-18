package com.shutterstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cartitemphs")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Cartitementity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer quantity;



    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cartentity cart;


    @ManyToOne
    @JoinColumn(name= "product_id")
    private Productentity product;


}
