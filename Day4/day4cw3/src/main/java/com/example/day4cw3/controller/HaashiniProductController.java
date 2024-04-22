package com.example.day4cw3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day4cw3.model.HaashiniProduct;
import com.example.day4cw3.services.HaashiniProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HaashiniProductController {
    public HaashiniProductService productService;
    public HaashiniProductController(HaashiniProductService productService)
    {
        this.productService=productService;
    }
    @PostMapping("/api/product")
    public ResponseEntity<HaashiniProduct> postMethodName(@RequestBody HaashiniProduct product) {
        if(productService.saveProduct(product))
        {
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/product")
    public ResponseEntity<List<HaashiniProduct>> getMethodName() {
        List<HaashiniProduct> list =  productService.getProducts();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/product/{productId}")
    public ResponseEntity<HaashiniProduct> getMethodName(@PathVariable("productId") int id) {
        HaashiniProduct p =  productService.getProductById(id);
        if(p==null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    
}
