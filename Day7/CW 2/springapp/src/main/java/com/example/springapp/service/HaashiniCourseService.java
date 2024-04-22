package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.HaashiniCourse;
import com.example.springapp.repository.HaashiniCourseRepo;

@Service
public class HaashiniCourseService {
    @Autowired
    private HaashiniCourseRepo rep;

    public boolean post(HaashiniCourse person)
    {
        try
        {
            rep.save(person);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<HaashiniCourse> getAll()
    {
        return rep.findAll();
    }

    public List<HaashiniCourse> getbyAge(String courseName)
    {
        return rep.findByCourseName(courseName);
    }
    
}
