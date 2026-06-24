package com.shutterstore.dto;


import com.shutterstore.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loginrequestdto {


    private String email;
    private String password;

}
