package com.example.bidirection.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bidirection.model.GayathriStudent;
import com.example.bidirection.model.GayathriStudentInfo;
import com.example.bidirection.repository.GayathriStudentInfoRepository;
import com.example.bidirection.repository.GayathriStudentRepository;

@Service
public class GayathriStudentService {
    public GayathriStudentRepository studentRepository;
    public GayathriStudentInfoRepository studentInfoRepository;
    public GayathriStudentService(GayathriStudentRepository studentRepository,GayathriStudentInfoRepository studentInfoRepository)
    {
        this.studentRepository = studentRepository;
        this.studentInfoRepository = studentInfoRepository;
    }
    public GayathriStudent saveStudent(GayathriStudent student)
    {
        return studentRepository.save(student);
    }
    public GayathriStudentInfo saveStudentInfo(GayathriStudentInfo studentInfo)
    {
        return studentInfoRepository.save(studentInfo);
    }
    public List<GayathriStudent> getStudents()
    {
        return studentRepository.findAll();
    }
}
