package com.team3.service.Impl;

import com.team3.dto.ProductDTO;
import com.team3.entity.Product;
import com.team3.repository.IProductRepository;
import com.team3.service.ICloudinaryService;
import com.team3.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ICloudinaryService cloudinaryService;

    @Override
    public void save(ProductDTO productDTO) {
        try {
            if (productDTO.getId() == null) {
                Product product = modelMapper.map(productDTO, Product.class);
                product.setImgUrl(cloudinaryService.uploadFile(productDTO.getFile(), "product"));
                productRepository.save(product);
            } else {
                Product existingProduct = productRepository.findById(productDTO.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + productDTO.getId()));
                existingProduct.setName(productDTO.getName());
                existingProduct.setPrice(productDTO.getPrice());
                existingProduct.setDescription(productDTO.getDescription());
                existingProduct.setAudioUrl(productDTO.getAudioUrl());
                if (productDTO.getFile().isEmpty()) {
                    existingProduct.setImgUrl(existingProduct.getImgUrl());
                } else {
                    existingProduct.setImgUrl(cloudinaryService.uploadFile(productDTO.getFile(), "product"));
                }
                productRepository.save(existingProduct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product) -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }


}
