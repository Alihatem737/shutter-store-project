package com.shutterstore.controller;


import com.shutterstore.dto.Brandrequestdto;
import com.shutterstore.dto.Brandresponsedto;
import com.shutterstore.services.Brandservice;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Brands")
@SecurityRequirement(name = "Bearer Authentication")
@RestController
@RequestMapping("/brands")
public class Brandcontroller {

    @Autowired
    private Brandservice brandservice;

    @PostMapping("addbrand")
    public Brandresponsedto addbrand(@Valid @RequestBody Brandrequestdto request){

        return brandservice.addbrand(request);

    }

    @GetMapping(path = "getallbarnds")
    public List<Brandresponsedto> getallbrands(){

        return brandservice.getallbrands();

    }

}
