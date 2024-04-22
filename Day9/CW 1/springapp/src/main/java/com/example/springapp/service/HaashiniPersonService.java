package com.example.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapp.model.HaashiniPerson;
import com.example.springapp.repository.HaashiniPersonRepo;

@Service
public class HaashiniPersonService {
    public HaashiniPersonRepo personRepo;

    public HaashiniPersonService(HaashiniPersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public boolean savePerson(HaashiniPerson person) {
        try {
            personRepo.save(person);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<HaashiniPerson> getPersonByAge(int age) {
        return personRepo.findByAge(age);
    }
}
