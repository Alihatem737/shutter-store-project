package com.shutterstore.repository;

import com.shutterstore.entity.Productentity;
import com.shutterstore.entity.Userentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Productrepo extends JpaRepository<Productentity, Long> {
}
