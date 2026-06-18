package com.shutterstore.dto;

import com.shutterstore.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Userresponsedto {

    private Long id ;
    private String name ;
    private String email;
    private Role role;
    private boolean is_verfied;
    private LocalDateTime created_at;

}
