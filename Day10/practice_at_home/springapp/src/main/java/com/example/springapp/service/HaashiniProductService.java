package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.HaashiniProduct;
import com.example.springapp.repository.HaashiniProductRepo;

@Service
public class HaashiniProductService {
    @Autowired
    private HaashiniProductRepo productRepo;

    public boolean saveProduct(HaashiniProduct product)
    {
        try
        {
            productRepo.save(product);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public List<HaashiniProduct> findByCategoryList(String category)
    {
        return productRepo.findByCategoryList(category);
    }

    public HaashiniProduct updateProduct(int productId, int quantityInStock)
    {
        productRepo.updateQuantity(productId, quantityInStock);
        return productRepo.findById(productId).orElse(null);
    }

    public HaashiniProduct deleteProduct(int productId)
    {
        productRepo.deleteProduct(productId);
        return productRepo.findById(productId).orElse(null);
    }
}