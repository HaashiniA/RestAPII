package com.example.cw1.controller;

import com.example.cw1.model.HaashiniPayroll;
import com.example.cw1.service.HaashiniPayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/{employeeId}/payroll")
public class HaashiniPayrollController {
    private final HaashiniPayrollService payrollService;

    public HaashiniPayrollController(HaashiniPayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping
    public ResponseEntity<HaashiniPayroll> createPayrollForEmployee(@PathVariable Long employeeId, @RequestBody HaashiniPayroll payroll) {
        HaashiniPayroll createdPayroll = payrollService.createPayroll(payroll);
        if (createdPayroll != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPayroll);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping
    public ResponseEntity<HaashiniPayroll> getPayrollForEmployee(@PathVariable Long employeeId) {
        HaashiniPayroll payroll = payrollService.getPayrollByEmployeeId(employeeId);
        if (payroll != null) {
            return ResponseEntity.ok(payroll);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
