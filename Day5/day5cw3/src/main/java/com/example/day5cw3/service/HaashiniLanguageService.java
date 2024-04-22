package com.example.day5cw3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day5cw3.model.HaashiniLanguage;
import com.example.day5cw3.repository.HaashiniLanguageRepo;

@Service
public class HaashiniLanguageService {
    private HaashiniLanguageRepo languageRepo;
    public HaashiniLanguageService(HaashiniLanguageRepo languageRepo)
    {
        this.languageRepo=languageRepo;
    }
    public boolean saveLanguage(HaashiniLanguage language)
    {
        try
        {
            languageRepo.save(language);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<HaashiniLanguage> getLanguages()
    {
        return languageRepo.findAll();
    }
    public boolean updateLanguage(int id,HaashiniLanguage language)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        try{
            languageRepo.save(language);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteLanguage(int id)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        languageRepo.deleteById(id);
        return true;
        
    }
    public HaashiniLanguage getLanguageById(int id)
    {
        return languageRepo.findById(id).orElse(null);
    }

}
