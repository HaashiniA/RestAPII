package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.HaashiniProduct;

import jakarta.transaction.Transactional;

@Repository
public interface HaashiniProductRepo extends JpaRepository<HaashiniProduct, Integer> {
    
    @Query(value = "SELECT p FROM Product p WHERE p.category = ?1")
    public List<HaashiniProduct> findByCategoryList(String category);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Product set quantity_in_stock = ?2 WHERE product_id = ?1", nativeQuery = true)
    void updateQuantity(int productId, int quantityInStock);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Product WHERE product_id = ?1", nativeQuery = true)
    void deleteProduct(int productId);
}
