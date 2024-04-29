package com.example.ce1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ce1.model.HaashiniEmployee;
import com.example.ce1.repository.HaashiniEmployeeRepo;

@Service
public class HaashiniEmployeeService {
    @Autowired
    HaashiniEmployeeRepo employeeRepo;

    @SuppressWarnings("null")
    public HaashiniEmployee setEmployee(HaashiniEmployee employee)
    {
        return employeeRepo.save(employee);
    }

    public List<HaashiniEmployee> getInnerEmployee()
    {
        return employeeRepo.getByInnerEmployees();
    }

    public List<HaashiniEmployee> getLeftOuterEmployee()
    {
        return employeeRepo.getByLeftOuterEmployees();
    }
}
