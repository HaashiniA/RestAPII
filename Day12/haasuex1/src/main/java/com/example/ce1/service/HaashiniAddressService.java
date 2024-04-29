package com.example.ce1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ce1.model.HaashiniAddress;
import com.example.ce1.repository.HaashiniAddressRepo;
import com.example.ce1.repository.HaashiniEmployeeRepo;

@Service
public class HaashiniAddressService {
    @Autowired
    HaashiniAddressRepo addressRepo;
    @Autowired
    HaashiniEmployeeRepo employeeRepo;
    public HaashiniAddress setAddressById(int id,HaashiniAddress address)
    {
        if(employeeRepo.existsById(id))
        {
            addressRepo.setByemployeeId(address.getCity(), address.getStreet(), id);
            return address;
        }
        else
        {
            return null;
        }
    }
}
