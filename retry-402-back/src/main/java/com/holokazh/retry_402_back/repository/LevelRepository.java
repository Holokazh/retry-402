package com.holokazh.retry_402_back.repository;

import com.holokazh.retry_402_back.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
    Level findById(Long id);
}
