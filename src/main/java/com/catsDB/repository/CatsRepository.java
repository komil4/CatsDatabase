package com.catsDB.repository;

import com.catsDB.models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CatsRepository extends JpaRepository<Cat, Integer> {}
