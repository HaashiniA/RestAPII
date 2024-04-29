package com.example.cw1.controller;

import com.example.cw1.model.HaashiniEmployee;
import com.example.cw1.service.HaashiniEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class HaashiniEmployeeController {
    private final HaashiniEmployeeService employeeService;

    public HaashiniEmployeeController(HaashiniEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<HaashiniEmployee> createEmployee(@RequestBody HaashiniEmployee employee) {
        HaashiniEmployee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping
    public ResponseEntity<List<HaashiniEmployee>> getAllEmployees() {
        List<HaashiniEmployee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<HaashiniEmployee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<HaashiniEmployee> employee = employeeService.getEmployeeById(employeeId);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

