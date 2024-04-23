package com.example.bidirection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bidirection.model.HaashiniStudent;



@Repository
public interface HaashiniStudentRepository extends JpaRepository<HaashiniStudent,Integer>{
    
}
