package com.shutterstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "wishlist")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Wishlistentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "user_id")
    private Userentity user;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Productentity product;

}
