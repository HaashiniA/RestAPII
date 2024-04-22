package com.example.day5cw1.service;

import org.springframework.stereotype.Service;

import com.example.day5cw1.model.HaashiniProduct;
import com.example.day5cw1.repository.HaashiniProductRepo;

@Service
public class HaashiniProductService {
    public HaashiniProductRepo productRepo;
    public HaashiniProductService(HaashiniProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean saveProduct(HaashiniProduct product)
    {
        try
        {
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,HaashiniProduct product)
    {
        if(this.getProductById(id)==null)
        {
            return false;
        }
        try{
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteProduct(int id)
    {
        if(this.getProductById(id) == null)
        {
            return false;
        }
        productRepo.deleteById(id);
        return true;
    }
    public HaashiniProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
