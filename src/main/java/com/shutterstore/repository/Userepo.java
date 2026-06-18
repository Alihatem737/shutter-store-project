package com.shutterstore.repository;

import com.shutterstore.entity.Userentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userepo extends JpaRepository<Userentity, Long> {
}
