package com.example.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relation.model.HaashiniStudent;

@Repository
public interface HaashiniStudentRepository extends JpaRepository<HaashiniStudent,Integer>{
    
}
