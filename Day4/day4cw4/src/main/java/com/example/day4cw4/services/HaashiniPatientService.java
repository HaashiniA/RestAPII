package com.example.day4cw4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw4.model.HaashiniPatient;
import com.example.day4cw4.repository.HaashiniPatientRepo;

@Service
public class HaashiniPatientService {
    public HaashiniPatientRepo patientRepo;
    public HaashiniPatientService(HaashiniPatientRepo patientRepo)
    {
        this.patientRepo = patientRepo;
    }
    public boolean savePatient(HaashiniPatient patient)
    {
        try{
            patientRepo.save(patient);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<HaashiniPatient> getPatients()
    {
        return patientRepo.findAll();
    }
    public HaashiniPatient getPatientById(int id)
    {
        Optional<HaashiniPatient> obj = patientRepo.findById(id);
        return obj.orElse(null);
    }
}
