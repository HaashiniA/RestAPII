package com.example.ce1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ce1.model.HaashiniEmployee;

public interface HaashiniEmployeeRepo extends JpaRepository<HaashiniEmployee,Integer> {
 
    @Query(value = "SELECT e.* FROM employee e INNER JOIN address a ON e.id = a.employee_id",nativeQuery = true)
    List<HaashiniEmployee> getByInnerEmployees();

    @Query(value = "SELECT e.* FROM employee e LEFT JOIN address a ON e.id = a.employee_id",nativeQuery = true)
    List<HaashiniEmployee> getByLeftOuterEmployees();
}