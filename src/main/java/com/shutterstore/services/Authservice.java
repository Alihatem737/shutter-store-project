package com.shutterstore.services;

import com.shutterstore.dto.Loginrequestdto;
import com.shutterstore.dto.Loginresponsedto;
import com.shutterstore.dto.Registerrequestdto;
import com.shutterstore.dto.Registerresponsedto;

public interface Authservice {


    Registerresponsedto register(Registerrequestdto request);

    Loginresponsedto login(Loginrequestdto request);
}
