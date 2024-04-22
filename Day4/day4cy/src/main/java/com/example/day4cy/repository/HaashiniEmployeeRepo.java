package com.example.day4cy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day4cy.model.HaashiniEmployee;


@Repository
public interface HaashiniEmployeeRepo extends JpaRepository<HaashiniEmployee,Integer>{
    
}
