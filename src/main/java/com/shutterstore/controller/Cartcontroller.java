package com.shutterstore.controller;


import com.shutterstore.dto.Cartrequestdto;
import com.shutterstore.dto.Cartresponsedto;
import com.shutterstore.dto.Updatecartitemdto;
import com.shutterstore.services.Cartservice;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Cart")
@SecurityRequirement(name = "Bearer Authentication")
@RestController
@RequestMapping("/cart")
public class Cartcontroller {


    @Autowired
    private Cartservice cartservice;

    @PostMapping("/add")
    public Cartresponsedto addtocart(@Valid @RequestBody Cartrequestdto request){
        return this.cartservice.addtocart(request);
    }


    @GetMapping("/getcart/{id}")
    public Cartresponsedto getcart(@PathVariable Long id){

        return this.cartservice.getcart(id);

    }


    @PutMapping("/update")
    public Cartresponsedto updatequantity(@Valid  @RequestBody Updatecartitemdto dto){
        return this.cartservice.updatequantity(dto);
    }


    @DeleteMapping("/deleteitem/{id}")
    public Cartresponsedto deleteitem(@PathVariable Long id){
        return this.cartservice.deleteitem(id);

    }


    @DeleteMapping("/clearcart/{id}")
    public Cartresponsedto clearcart(@PathVariable Long id){
        return this.cartservice.clearcart(id);

    }
}
