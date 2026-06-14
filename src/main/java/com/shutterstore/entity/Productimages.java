package com.shutterstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "productimages")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Productimages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imageurl")
    private String imageurl;

      @ManyToOne
      @JoinColumn(name = "product_id")
      private Productentity product;




}
