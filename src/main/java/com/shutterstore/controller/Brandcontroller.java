package com.shutterstore.controller;


import com.shutterstore.dto.Brandrequestdto;
import com.shutterstore.dto.Brandresponsedto;
import com.shutterstore.services.Brandservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class Brandcontroller {

    @Autowired
    private Brandservice brandservice;

    @PostMapping("addbrand")
    public Brandresponsedto addbrand(@RequestBody Brandrequestdto request){

        return brandservice.addbrand(request);

    }

    @GetMapping(path = "getallbarnds")
    public List<Brandresponsedto> getallbrands(){

        return brandservice.getallbrands();

    }

}
