package com.shutterstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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



}
