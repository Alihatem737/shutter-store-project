package com.shutterstore.repository;

import com.shutterstore.entity.Reviewentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface Reviewrepo extends JpaRepository<Reviewentity , Long> {


    List<Reviewentity> findByProduct_id(Long productId);
    List<Reviewentity> findByUser_id(Long userId);

}
