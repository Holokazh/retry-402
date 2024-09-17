package com.holokazh.retry_402_back.repository;

import com.holokazh.retry_402_back.model.Shape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeRepository extends JpaRepository<Shape, Integer> {
    Shape findById(Long id);
}
