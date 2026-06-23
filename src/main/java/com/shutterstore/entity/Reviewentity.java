package com.shutterstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "review")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reviewentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer rating; //1-5

    @Column(columnDefinition = "TEXT")
    private String comment;


    @Column(name = "created_at")
    private LocalDateTime createdAt ;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Userentity user;


    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Productentity product;




}
