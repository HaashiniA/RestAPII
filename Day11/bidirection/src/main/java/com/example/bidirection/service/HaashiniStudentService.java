package com.example.bidirection.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bidirection.model.HaashiniStudent;
import com.example.bidirection.model.HaashiniStudentInfo;
import com.example.bidirection.repository.HaashiniStudentInfoRepository;
import com.example.bidirection.repository.HaashiniStudentRepository;

@Service
public class HaashiniStudentService {
    public HaashiniStudentRepository studentRepository;
    public HaashiniStudentInfoRepository studentInfoRepository;
    public HaashiniStudentService(HaashiniStudentRepository studentRepository,HaashiniStudentInfoRepository studentInfoRepository)
    {
        this.studentRepository = studentRepository;
        this.studentInfoRepository = studentInfoRepository;
    }
    public HaashiniStudent saveStudent(HaashiniStudent student)
    {
        return studentRepository.save(student);
    }
    public HaashiniStudentInfo saveStudentInfo(HaashiniStudentInfo studentInfo)
    {
        return studentInfoRepository.save(studentInfo);
    }
    public List<HaashiniStudent> getStudents()
    {
        return studentRepository.findAll();
    }
}
