package com.example.relation.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.relation.model.HaashiniStudent;
import com.example.relation.service.HaashiniStudentService;
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
    @PostMapping("/api/student")
    public HaashiniStudent postMethodName(@RequestBody HaashiniStudent student) {
        return studentService.saveStudent(student);
    }
    @GetMapping("/api/student")
    public List<HaashiniStudent> getMethodName() {
        return studentService.getStudents();
    }
    
}
