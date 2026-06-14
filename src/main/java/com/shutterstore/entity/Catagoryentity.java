package com.shutterstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "categories")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Catagoryentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String  descrption ;



    @OneToMany(mappedBy = "catagory")
    private List<Productentity> products;
}
