package com.example.relation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.relation.model.HaashiniStudent;
import com.example.relation.repository.HaashiniStudentRepository;

@Service
public class HaashiniStudentService {
    public HaashiniStudentRepository studentRepository;
    public HaashiniStudentService(HaashiniStudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    public HaashiniStudent saveStudent(HaashiniStudent student)
    {
        return studentRepository.save(student);
    }
    public List<HaashiniStudent> getStudents()
    {
        return studentRepository.findAll();
    }
}
