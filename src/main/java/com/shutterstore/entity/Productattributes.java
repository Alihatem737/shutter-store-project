package com.shutterstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "productattribute")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Productattributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "attributename")
    private String attributename;

    @Column(name = "attributevalue")
    private String attributevalue;



    @ManyToOne
    @JoinColumn(name = "product_id")
    private Productentity product;

}
