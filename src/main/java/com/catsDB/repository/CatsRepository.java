package com.catsDB.repository;

import com.catsDB.models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatsRepository extends JpaRepository<Cat, Integer> {
}
