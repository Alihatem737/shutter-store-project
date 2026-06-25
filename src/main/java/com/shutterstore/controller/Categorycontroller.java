package com.shutterstore.controller;


import com.shutterstore.dto.Categoryrequestdto;
import com.shutterstore.dto.Categoryresponsedto;
import com.shutterstore.services.Categoryservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class Categorycontroller {

    @Autowired private Categoryservice categoryservice;

    @PostMapping(path = "addcategory")
    public Categoryresponsedto addcategory(@Valid @RequestBody Categoryrequestdto request){
        return categoryservice.addcategory(request);
    }

    @GetMapping
    public List<Categoryresponsedto> getallcategories(){
        return categoryservice.getallcategories();
    }
}
