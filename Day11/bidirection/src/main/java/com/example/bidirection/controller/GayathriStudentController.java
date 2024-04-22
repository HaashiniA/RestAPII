package com.example.bidirection.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bidirection.model.GayathriStudent;
import com.example.bidirection.model.GayathriStudentInfo;
import com.example.bidirection.service.GayathriStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class GayathriStudentController {
    public GayathriStudentService studentService;
    public GayathriStudentController(GayathriStudentService studentService)
    {
        this.studentService = studentService;
    }
    @PostMapping("/api/poststudent")
    public GayathriStudent postMethodName(@RequestBody GayathriStudent student) {
        return studentService.saveStudent(student);
    }
    @PostMapping("/api/poststudentinfo")
    public GayathriStudentInfo postMethodName(@RequestBody GayathriStudentInfo studentInfo) {
        return studentService.saveStudentInfo(studentInfo);
    }
    @GetMapping("/api/student")
    public List<GayathriStudent> getMethodName() {
        return studentService.getStudents();
    }
    
}