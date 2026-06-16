package com.shutterstore.services;


import com.shutterstore.dto.Categoryrequestdto;
import com.shutterstore.dto.Categoryresponsedto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Categoryservice {


    Categoryresponsedto addcategory(Categoryrequestdto request);

    List<Categoryresponsedto> getallcategories();


}
