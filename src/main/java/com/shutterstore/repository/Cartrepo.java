package com.shutterstore.repository;

import com.shutterstore.entity.Cartentity;
import com.shutterstore.entity.Userentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Cartrepo extends JpaRepository<Cartentity , Long> {


    Optional<Cartentity> findByUser(Userentity user);
}
