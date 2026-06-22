package com.shutterstore.repository;


import com.shutterstore.entity.Orderentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Orderrepo extends JpaRepository<Orderentity , Long> {



    List<Orderentity> findByUserId(Long userid);
}
