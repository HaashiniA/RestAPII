package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.HaashiniStudentDetail;
import com.example.springapp.repository.HaashiniStudentDetailRepository;
import com.example.springapp.repository.HaashiniStudentRepository;

@Service
public class HaashiniStudentDetailService {
    @Autowired
    HaashiniStudentDetailRepository studentDetailRepository;
    @Autowired
    HaashiniStudentRepository studentRepository;
    public HaashiniStudentDetail addStudentDetail(int id,HaashiniStudentDetail studentDetail)
    {
        if(studentRepository.existsById(id))
        {
            studentDetailRepository.addStudentDetail(studentDetail.getAddress(),studentDetail.getPhoneNumber(),id);
            return studentDetail;
        }
        else
        return null;
    }
    
    
}
