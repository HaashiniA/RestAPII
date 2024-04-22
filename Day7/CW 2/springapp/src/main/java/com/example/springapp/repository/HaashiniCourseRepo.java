package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.HaashiniCourse;
import java.util.List;


@Repository
public interface HaashiniCourseRepo extends JpaRepository<HaashiniCourse,Integer>{

    List<HaashiniCourse> findByCourseName(String courseName);
    
}
