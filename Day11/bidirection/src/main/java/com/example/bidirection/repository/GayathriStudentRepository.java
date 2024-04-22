package com.example.bidirection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bidirection.model.GayathriStudent;



@Repository
public interface GayathriStudentRepository extends JpaRepository<GayathriStudent,Integer>{
    
}
