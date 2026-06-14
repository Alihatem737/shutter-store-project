package com.shutterstore.repository;

import com.shutterstore.entity.Catagoryentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Categoryrepo extends JpaRepository<Catagoryentity , Long> {
}
