package com.shutterstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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



    @OneToOne
    @JoinColumn(name = "user_id")
    private Userentity user;


    @OneToMany(mappedBy = "cart")
    private List<Cartitementity> items;






//    @OneToMany
//    user

}
