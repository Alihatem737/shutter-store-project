package com.shutterstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "productimages")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Verificationtoken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "token")
    private String token;

    @Column(name = "type")
    private String type;

    @Column(name = "expiresat")
    private LocalDateTime expiresat;



}

