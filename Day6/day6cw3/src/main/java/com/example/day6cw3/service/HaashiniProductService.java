package com.example.day6cw3.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw3.model.HaashiniProduct;
import com.example.day6cw3.repository.HaashiniProductRepo;

@Service
public class HaashiniProductService {
    public HaashiniProductRepo productRepo;
    public HaashiniProductService(HaashiniProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean postProduct(HaashiniProduct product)
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
    public List<HaashiniProduct> pagination(int offset,int size)
    {
        return productRepo.findAll(PageRequest.of(offset, size)).getContent();
    }
    public List<HaashiniProduct> sortPagination(int offset,int size,String field)
    {
        return productRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
    public HaashiniProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
