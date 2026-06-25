package com.shutterstore.services.impl;


import com.shutterstore.dto.Productrequestdto;
import com.shutterstore.dto.Productresponsedto;
import com.shutterstore.entity.Brandentity;
import com.shutterstore.entity.Categoryentity;
import com.shutterstore.entity.Productentity;
import com.shutterstore.repository.Brandrepo;
import com.shutterstore.repository.Productrepo;
import com.shutterstore.services.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shutterstore.mapper.Productmapper;
import com.shutterstore.repository.Categoryrepo;


import java.util.List;

@Service

public class Productserviceimpl implements Productservice {

    @Autowired
    private Productrepo productrepo;

    @Autowired
    private Brandrepo brandrepo;


    @Autowired
    private Categoryrepo  categoryrepo;

    @Autowired
    private Productmapper productmapper;

    @Override
    public Productresponsedto addproduct(Productrequestdto request) {

        Brandentity brand = brandrepo.findById(request.getBrandId()).orElseThrow();

        Categoryentity catagory = categoryrepo.findById(request.getCategoryId()).orElseThrow();


        Productentity product = productmapper.toentity(request) ;


        product.setBrand(brand);
        product.setCatagory(catagory);



        productrepo.save(product);

        return productmapper.toresponse(product);
    }

    @Override
    public Productresponsedto getProductbyid(Long id) {
        Productentity product = productrepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return  productmapper.toresponse(product);

    }

    @Override
    public List<Productresponsedto> getAllproduct() {
        List<Productentity> products = productrepo.findAll();

        return productmapper.toresponselist(products);
    }

    @Override
    public Productresponsedto updateProduct(Long id, Productrequestdto request) {

        Productentity product =   productrepo.findById(id).orElseThrow();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDescrption(request.getDescription());
        product.setStock(request.getStock());
        productrepo.save(product);

       return productmapper.toresponse(product);


    }

    @Override
    public void deleteProduct(Long id) {
       Productentity product = productrepo.findById(id).
               orElseThrow(()->new RuntimeException("not found"));

       productrepo.delete(product);
    }
}
