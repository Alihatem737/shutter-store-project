package com.shutterstore.services.impl;

import com.shutterstore.dto.Brandrequestdto;
import com.shutterstore.dto.Brandresponsedto;
import com.shutterstore.entity.Brandentity;
import com.shutterstore.mapper.Brandmapper;
import com.shutterstore.repository.Brandrepo;
import com.shutterstore.services.Brandservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Brandserviceimpl implements Brandservice {

    @Autowired
    private Brandmapper brandmapper;

    @Autowired
    private Brandrepo brandrepo;

    @Override
    public Brandresponsedto addbrand(Brandrequestdto request) {
        Brandentity brand = brandmapper.toentity(request) ;

        brandrepo.save(brand);

        return brandmapper.toresponse(brand);
    }

    @Override
    public List<Brandresponsedto> getallbrands() {
        List<Brandentity> brands = brandrepo.findAll();

        return brandmapper.toresponselist(brands) ;
    }
}
