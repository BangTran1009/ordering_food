package com.team3.mappers;

import com.team3.dto.requests.CreateProductDTO;
import com.team3.dto.requests.UpdateProductDTO;
import com.team3.dto.responses.ProductResponseDTO;
import com.team3.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
     Product toProduct(CreateProductDTO createProductDTO);
     ProductResponseDTO toProductResponse(Product product);
     List<ProductResponseDTO> mapToProductResponseDTO(List<Product> products);
     Product toProduct(UpdateProductDTO updateProductDTO);
     UpdateProductDTO toUpdate(ProductResponseDTO productResponseDTO);
}
