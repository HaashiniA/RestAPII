package com.example.cw1.service;

import com.example.cw1.model.HaashiniPayroll;
import com.example.cw1.repository.HaashiniPayrollRepo;
import org.springframework.stereotype.Service;

@Service
public class HaashiniPayrollService {
    private final HaashiniPayrollRepo payrollRepo;

    public HaashiniPayrollService(HaashiniPayrollRepo payrollRepo) {
        this.payrollRepo = payrollRepo;
    }

    public HaashiniPayroll createPayroll(HaashiniPayroll payroll) {
        return payrollRepo.save(payroll);
    }

    public HaashiniPayroll getPayrollByEmployeeId(Long employeeId) {
        return payrollRepo.findById(employeeId).orElse(null);
    }
}
