package com.example.day5cw2.service;

import org.springframework.stereotype.Service;

import com.example.day5cw2.model.HaashiniEmployee;
import com.example.day5cw2.repository.HaashiniEmployeeRepo;

@Service
public class HaashiniEmployeeService {
    public HaashiniEmployeeRepo employeeRepo;
    public HaashiniEmployeeService(HaashiniEmployeeRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }
    public boolean saveEmployee(HaashiniEmployee employee)
    {
        try
        {
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,HaashiniEmployee employee)
    {
        if(this.getEmployeeById(id)==null)
        {
            return false;
        }
        try{
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteEmployee(int id)
    {
        if(this.getEmployeeById(id) == null)
        {
            return false;
        }
        employeeRepo.deleteById(id);
        return true;
    }
    public HaashiniEmployee getEmployeeById(int id)
    {
        return employeeRepo.findById(id).orElse(null);
    }
}
