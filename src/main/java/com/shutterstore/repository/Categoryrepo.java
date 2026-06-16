package com.shutterstore.repository;

import com.shutterstore.entity.Categoryentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Categoryrepo extends JpaRepository<Categoryentity, Long> {
}
