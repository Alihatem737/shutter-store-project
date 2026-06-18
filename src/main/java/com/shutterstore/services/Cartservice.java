package com.shutterstore.services;

import com.shutterstore.dto.Cartrequestdto;
import com.shutterstore.dto.Cartresponsedto;
import com.shutterstore.dto.Updatecartitemdto;

public interface Cartservice {



    Cartresponsedto addtocart (Cartrequestdto request);

    Cartresponsedto getcart (Long id);

    Cartresponsedto updatequantity(Updatecartitemdto dto);

    Cartresponsedto deleteitem(Long id);

    Cartresponsedto clearcart(Long id);


}
