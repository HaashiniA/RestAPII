package com.example.day4cy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cy.model.HaashiniEmployee;
import com.example.day4cy.repository.HaashiniEmployeeRepo;

@Service
public class HaashiniEmployeeService {
    public HaashiniEmployeeRepo employeeRepo;
    public HaashiniEmployeeService(HaashiniEmployeeRepo employeeRepo)
    {
        this.employeeRepo=employeeRepo;
    }
    public boolean saveEmployee(HaashiniEmployee employee)
    {
        try{
            employeeRepo.save(employee);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<HaashiniEmployee> getEmployees()
    {
        return employeeRepo.findAll();
    }
    public HaashiniEmployee getEmployeeById(int id)
    {
        Optional<HaashiniEmployee> obj = employeeRepo.findById(id);
        return obj.orElse(null);
    }
}
