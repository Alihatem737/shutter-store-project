package com.shutterstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "Brands")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brandentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String logoUrl;


    @OneToMany(mappedBy = "brand")
    private List<Productentity> products;
}
