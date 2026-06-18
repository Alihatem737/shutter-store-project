package com.shutterstore.dto;

import com.shutterstore.entity.Role;

import java.time.LocalDateTime;

public class Userresponsedto {

    private Long id ;
    private String name ;
    private String email;
    private Role role;
    private boolean is_verfied;
    private LocalDateTime created_at;

}
