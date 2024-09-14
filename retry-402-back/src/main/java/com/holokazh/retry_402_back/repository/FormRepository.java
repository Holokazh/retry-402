package com.holokazh.retry_402_back.repository;

import com.holokazh.retry_402_back.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, Integer> {
    Form findById(Long id);
}
