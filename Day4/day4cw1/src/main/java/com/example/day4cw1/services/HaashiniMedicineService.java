package com.example.day4cw1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw1.model.HaashiniMedicine;
import com.example.day4cw1.repository.HaashiniMedicineRepo;

@Service
public class HaashiniMedicineService {
    public HaashiniMedicineRepo medicineRepo;
    public HaashiniMedicineService(HaashiniMedicineRepo medicineRepo)
    {
        this.medicineRepo = medicineRepo;
    }
    public boolean saveMedicine(HaashiniMedicine medicine)
    {
        try{
            medicineRepo.save(medicine);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<HaashiniMedicine> getMedicines()
    {
        return medicineRepo.findAll();
    }

    public HaashiniMedicine MedicineById(int id)
    {
        Optional<HaashiniMedicine> obj = medicineRepo.findById(id);
        return obj.orElse(new HaashiniMedicine());
    }

}
