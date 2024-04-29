package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.HaashiniStudent;
import com.example.springapp.repository.HaashiniStudentRepository;

@Service
public class HaashiniStudentService {
    @Autowired
    HaashiniStudentRepository studentRepository;
    public HaashiniStudent addStudents(HaashiniStudent student)
    {
        return studentRepository.save(student);
    }
    public List<HaashiniStudent>getStudent()
    {
        return studentRepository.findAll();
    }
    public List<HaashiniStudent>getStudentInner()
    {
        return studentRepository.getStudentInner();
    }
    public List<HaashiniStudent>getStudentLeftOuter()
    {
        return studentRepository.getStudentsLeftOuter();
    }
    
}
