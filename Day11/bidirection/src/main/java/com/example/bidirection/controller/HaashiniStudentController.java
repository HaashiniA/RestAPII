package com.example.bidirection.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bidirection.model.HaashiniStudent;
import com.example.bidirection.model.HaashiniStudentInfo;
import com.example.bidirection.service.HaashiniStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HaashiniStudentController {
    public HaashiniStudentService studentService;
    public HaashiniStudentController(HaashiniStudentService studentService)
    {
        this.studentService = studentService;
    }
    @PostMapping("/api/poststudent")
    public HaashiniStudent postMethodName(@RequestBody HaashiniStudent student) {
        return studentService.saveStudent(student);
    }
    @PostMapping("/api/poststudentinfo")
    public HaashiniStudentInfo postMethodName(@RequestBody HaashiniStudentInfo studentInfo) {
        return studentService.saveStudentInfo(studentInfo);
    }
    @GetMapping("/api/student")
    public List<HaashiniStudent> getMethodName() {
        return studentService.getStudents();
    }
    
}