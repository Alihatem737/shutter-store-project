package com.shutterstore.repository;

import com.shutterstore.entity.Cartentity;
import com.shutterstore.entity.Cartitementity;
import com.shutterstore.entity.Productentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Cartitemrepo extends JpaRepository<Cartitementity , Long> {


    //unquie item in cart
    Optional<Cartitementity> findByCartAndProduct (Cartentity cart , Productentity product);

}
