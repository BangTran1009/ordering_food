package com.team3.service;

import com.team3.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    void save(ProductDTO productDTO);
    List<ProductDTO> getAll();
    ProductDTO getById(Long id);
    void delete(Long id);
}
