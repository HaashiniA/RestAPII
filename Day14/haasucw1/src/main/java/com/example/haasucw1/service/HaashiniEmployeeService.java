package com.example.cw1.service;

import com.example.cw1.model.HaashiniEmployee;
import com.example.cw1.repository.HaashiniEmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HaashiniEmployeeService {
    private final HaashiniEmployeeRepo employeeRepo;

    public HaashiniEmployeeService(HaashiniEmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public HaashiniEmployee createEmployee(HaashiniEmployee employee) {
        return employeeRepo.save(employee);
    }

    public List<HaashiniEmployee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<HaashiniEmployee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }
}
