package com.shutterstore.controller;

import com.shutterstore.dto.Loginrequestdto;
import com.shutterstore.dto.Loginresponsedto;
import com.shutterstore.dto.Registerrequestdto;
import com.shutterstore.dto.Registerresponsedto;
import com.shutterstore.services.Authservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class Authcontroller {

    @Autowired
    private Authservice authservice;

    @PostMapping("/register")
    public Registerresponsedto register(@RequestBody Registerrequestdto request) {
        return authservice.register(request);
    }


    @PostMapping("/login")
    public Loginresponsedto login(@RequestBody Loginrequestdto request) {
        return authservice.login(request);
    }


    @GetMapping("/verify")
    public String verifyEmail(@RequestParam String token) {

        authservice.verifyEmail(token);

        return "Email verified successfully";
    }
}