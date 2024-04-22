package com.example.day4cw2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw2.model.HaashiniJob;
import com.example.day4cw2.repository.HaashiniJobRepo;

@Service
public class HaashiniJobService {
    public HaashiniJobRepo jobRepo;
    public HaashiniJobService(HaashiniJobRepo jobRepo)
    {
        this.jobRepo = jobRepo;
    }
    public boolean saveJob(HaashiniJob job)
    {
        try{
            jobRepo.save(job);
        } 
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<HaashiniJob> getJobs()
    {
        return jobRepo.findAll();
    }
    public HaashiniJob getJobById(int id)
    {
        Optional<HaashiniJob> obj = jobRepo.findById(id);
        return obj.orElse(null);
    }
}
