package com.shutterstore.repository;

import com.shutterstore.entity.Brandentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Brandrepo extends JpaRepository<Brandentity , Long> {
}
