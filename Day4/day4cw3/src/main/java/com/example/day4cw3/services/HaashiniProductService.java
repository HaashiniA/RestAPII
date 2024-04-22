package com.example.day4cw3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw3.model.HaashiniProduct;
import com.example.day4cw3.repository.HaashiniProductRepo;

@Service
public class HaashiniProductService {
    public HaashiniProductRepo productRepo;
    public HaashiniProductService(HaashiniProductRepo productRepo)
    {
        this.productRepo=productRepo;
    }
    public boolean saveProduct(HaashiniProduct product)
    {
        try{
            productRepo.save(product);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<HaashiniProduct> getProducts()
    {
        return productRepo.findAll();
    }
    public HaashiniProduct getProductById(int id)
    {
        Optional<HaashiniProduct> obj = productRepo.findById(id);
        return obj.orElse(new HaashiniProduct());
    }
}
