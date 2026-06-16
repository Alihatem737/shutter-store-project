package com.shutterstore.services;

import com.shutterstore.dto.Brandrequestdto;
import com.shutterstore.dto.Brandresponsedto;

import java.util.List;

public interface Brandservice {





    Brandresponsedto addbrand(Brandrequestdto request);
    List<Brandresponsedto> getallbrands();
}
