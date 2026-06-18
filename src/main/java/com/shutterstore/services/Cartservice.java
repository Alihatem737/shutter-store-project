package com.shutterstore.services;

import com.shutterstore.dto.Cartrequestdto;
import com.shutterstore.dto.Cartresponsedto;

public interface Cartservice {



    Cartresponsedto addtocart (Cartrequestdto request);
}
