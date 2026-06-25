package com.shutterstore.entity;


import jakarta.persistence.*;
import lombok.*;

import com.shutterstore.entity.Role;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Userentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "name")
    private String name ;

    @Column(nullable = false , unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // enum role and store on string

    @Enumerated(EnumType.STRING)//Admin-admin-ADMN
    @Column(nullable = false)
    private Role role;

    @Column(name = "is_verified")
    private boolean is_verfied;

    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();




    @OneToOne(mappedBy = "user")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
   private Cartentity cart;


    @OneToMany(mappedBy = "user")
    private List<Orderentity> orders;





}
