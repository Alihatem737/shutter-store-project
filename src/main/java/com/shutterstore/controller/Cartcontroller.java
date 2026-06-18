package com.shutterstore.controller;


import com.shutterstore.dto.Cartrequestdto;
import com.shutterstore.dto.Cartresponsedto;
import com.shutterstore.services.Cartservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class Cartcontroller {


    @Autowired
    private Cartservice cartservice;

    @PostMapping("/add")
    public Cartresponsedto addtocart(@RequestBody Cartrequestdto request){
        return this.cartservice.addtocart(request);
    }
}
