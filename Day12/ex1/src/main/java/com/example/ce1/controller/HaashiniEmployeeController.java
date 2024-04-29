package com.example.ce1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.model.HaashiniEmployee;
import com.example.ce1.service.HaashiniEmployeeService;

@RestController
public class HaashiniEmployeeController {
    @Autowired
    HaashiniEmployeeService employeeService;

    @PostMapping("/employee")
    public HaashiniEmployee setMethod(@RequestBody HaashiniEmployee employee)
    {
        return employeeService.setEmployee(employee);
    }

    @GetMapping("/employees-inner-join")
    public List<HaashiniEmployee> getInnerMethod()
    {
        return employeeService.getInnerEmployee();
    }

    @GetMapping("/employees-left-outer-join")
    public List<HaashiniEmployee> getLeftMethod()
    {
        return employeeService.getLeftOuterEmployee();
    }
}
