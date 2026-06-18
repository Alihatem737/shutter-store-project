package com.shutterstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.shutterstore.entity.Role;
import java.time.LocalDateTime;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "is_verified")
    private boolean is_verfied;

    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();




    @OneToOne(mappedBy = "user")
   private Cartentity cart;






}
