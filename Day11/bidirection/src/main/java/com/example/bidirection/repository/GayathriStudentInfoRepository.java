package com.example.bidirection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bidirection.model.GayathriStudentInfo;

@Repository
public interface GayathriStudentInfoRepository extends JpaRepository<GayathriStudentInfo,Integer>{
    
}