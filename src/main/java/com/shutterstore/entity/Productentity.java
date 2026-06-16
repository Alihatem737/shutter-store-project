package com.shutterstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Table(name = "products")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Productentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String  descrption ;

    @Column(nullable = false)
    private BigDecimal price ;

    @Column(nullable = false)
    private Integer  stock ;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Condition  condition ;

    @Column(name = "is_available")
    private Boolean  is_available ;



    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brandentity brand;

    @ManyToOne
    @JoinColumn(name = "catgory_id")
    private Categoryentity catagory;



    @OneToMany(mappedBy = "product")
    private List<Productimages> productimages;

    @OneToMany(mappedBy = "product")
    private List<Productattributes> productattributes;










}
