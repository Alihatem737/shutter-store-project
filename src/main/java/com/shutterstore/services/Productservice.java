package com.shutterstore.services;

import com.shutterstore.dto.Productrequestdto;
import com.shutterstore.dto.Productresponsedto;

import java.util.List;

public interface Productservice {


    Productresponsedto addproduct (Productrequestdto request);
    Productresponsedto getProductbyid(Long id);
    List<Productresponsedto> getAllproduct();
    Productresponsedto updateProduct(Long id , Productrequestdto request);
    void deleteProduct (Long id);



}
