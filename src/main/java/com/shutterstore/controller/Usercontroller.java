package com.shutterstore.controller;


import com.shutterstore.dto.Userrequestdto;
import com.shutterstore.dto.Userresponsedto;
import com.shutterstore.services.Userservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private Userservice userservice;


    @PostMapping("/register")
    public Userresponsedto register (@Valid @RequestBody Userrequestdto request){
        return this.userservice.registeruser(request);
    }




}
