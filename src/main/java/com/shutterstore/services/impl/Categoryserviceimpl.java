package com.shutterstore.services.impl;


import com.shutterstore.dto.Categoryrequestdto;
import com.shutterstore.dto.Categoryresponsedto;
import com.shutterstore.entity.Categoryentity;
import com.shutterstore.mapper.Categorymapper;
import com.shutterstore.repository.Categoryrepo;
import com.shutterstore.services.Categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Categoryserviceimpl implements Categoryservice {

    @Autowired
    private Categorymapper categorymapper;

    @Autowired
    private Categoryrepo categoryrepo;

    @Override
    public Categoryresponsedto addcategory(Categoryrequestdto request) {
        Categoryentity category = categorymapper.toentity(request);

        categoryrepo.save(category);

        return categorymapper.toresponse(category);


    }

    @Override
    public List<Categoryresponsedto> getallcategories() {
        List<Categoryentity> categories = categoryrepo.findAll();

        return categorymapper.toresponselist(categories);
    }
}
