package com.shutterstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
