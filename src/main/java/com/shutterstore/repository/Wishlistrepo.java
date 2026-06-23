package com.shutterstore.repository;

import com.shutterstore.entity.Wishlistentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Wishlistrepo extends JpaRepository<Wishlistentity , Long> {


    List<Wishlistentity> findByUser_Id(Long userId);

// لا للتكرار
    Optional<Wishlistentity> findByUser_IdAndProduct_Id(Long userId, Long productId);



}
