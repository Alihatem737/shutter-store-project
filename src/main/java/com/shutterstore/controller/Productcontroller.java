package com.shutterstore.controller;


import com.shutterstore.dto.Productrequestdto;
import com.shutterstore.dto.Productresponsedto;
import com.shutterstore.services.Productservice;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Products")
@SecurityRequirement(name = "Bearer Authentication")
@RestController
@RequestMapping("/product")
public class Productcontroller {

    @Autowired
    private Productservice productservice;

    @PostMapping(path = "/addproduct")
    public Productresponsedto ddproduct (@Valid @RequestBody Productrequestdto dto){
        return this.productservice.addproduct(dto );
    }


    @GetMapping(path = "/{id}")
    public Productresponsedto getproductbyid(@PathVariable Long id){
        return this.productservice.getProductbyid(id);
    }



    @GetMapping(path = "/getallproduct")
    public List<Productresponsedto> getallproduct(){
        return this.productservice.getAllproduct();
    }


    @PutMapping("/update/{id}")
    public Productresponsedto updateproduct(@Valid @PathVariable Long id, @RequestBody Productrequestdto dto ){
        return productservice.updateProduct( id,dto);

    }


    @DeleteMapping("/delete/{id}")
    public void deleteproduct(@PathVariable Long id){
         this.productservice.deleteProduct(id);

    }
}
