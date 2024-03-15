package com.team3.repository;

import com.team3.dto.responses.ProductResponseDTO;
import com.team3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT c FROM Product c WHERE c.name LIKE %:keyword%")
    List<Product> findProducts(String keyword);

    Product findBySlug(String slug);
}
