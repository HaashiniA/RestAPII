package com.example.day4cy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4cy.model.HaashiniEmployee;
import com.example.day4cy.service.HaashiniEmployeeService;

@RestController
public class HaashiniEmployeeController {
    public HaashiniEmployeeService employeeService;
    public HaashiniEmployeeController(HaashiniEmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }
    @PostMapping("/api/employee")
    public ResponseEntity<HaashiniEmployee> postMethodName(@RequestBody HaashiniEmployee employee) {
        if(employeeService.saveEmployee(employee))
        {
            return new ResponseEntity<>(employee,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/employee")
    public ResponseEntity<List<HaashiniEmployee>> getMethodName() {
        List<HaashiniEmployee> list =  employeeService.getEmployees();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/employee/{employeeId}")
    public ResponseEntity<HaashiniEmployee> getMethodName(@PathVariable("employeeId") int id) {
        HaashiniEmployee p =  employeeService.getEmployeeById(id);
        if(p==null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
}
