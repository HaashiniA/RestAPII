package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springapp.model.HaashiniPerson;

public interface HaashiniPersonRepo extends JpaRepository<HaashiniPerson, Integer> {
    @Query("SELECT p FROM Person p WHERE age=?1")
    List<HaashiniPerson> findByAge(int age);
}
