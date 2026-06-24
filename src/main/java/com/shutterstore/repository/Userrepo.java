package com.shutterstore.repository;

import com.shutterstore.entity.Userentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Userrepo extends JpaRepository<Userentity, Long> {

    Optional<Userentity> findByEmail (String email);

}
