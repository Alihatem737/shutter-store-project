package com.shutterstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "cart")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cartentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imageurl")
    private String imageurl;



    @OneToOne
    @JoinColumn(name = "user_id")
    private Userentity user;



//    @OneToMany
//    user

}
