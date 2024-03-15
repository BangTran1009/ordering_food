package com.team3.service;

import com.team3.dto.requests.CreateProductDTO;
import com.team3.dto.requests.UpdateProductDTO;
import com.team3.dto.responses.ProductResponseDTO;
import com.team3.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {
    void create(CreateProductDTO createProductDTO);
    void update(UpdateProductDTO updateProductDTO);
    List<ProductResponseDTO> getAll();
    Page<Product> getAll(String keyword, int pageNo);
    ProductResponseDTO getById(Long id);
    ProductResponseDTO findBySlug(String slug);
    void delete(Long id);
}
