package com.shutterstore.controller;

import com.shutterstore.dto.Loginrequestdto;
import com.shutterstore.dto.Loginresponsedto;
import com.shutterstore.dto.Registerrequestdto;
import com.shutterstore.dto.Registerresponsedto;
import com.shutterstore.services.Authservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class Authcontroller {


    //Client
    //   ↓
    //Controller
    //   ↓
    //Validation
    //   ↓
    //Service


    @Autowired
    private Authservice authservice;

    @PostMapping("/register")
    public Registerresponsedto register(@Valid @RequestBody Registerrequestdto request) {
        return authservice.register(request);
    }


    @PostMapping("/login")
    public Loginresponsedto login( @Valid @RequestBody Loginrequestdto request) {
        return authservice.login(request);
    }


    @GetMapping("/verify")
    public String verifyEmail(@RequestParam String token) {

        authservice.verifyEmail(token);

        return "Email verified successfully";
    }
}