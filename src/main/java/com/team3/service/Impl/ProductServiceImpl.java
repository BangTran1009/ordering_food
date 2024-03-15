package com.team3.service.Impl;

import com.team3.dto.requests.CreateProductDTO;
import com.team3.dto.requests.UpdateProductDTO;
import com.team3.dto.responses.ProductResponseDTO;
import com.team3.entity.Product;
import com.team3.mappers.ProductMapper;
import com.team3.repository.IProductRepository;
import com.team3.service.ICloudinaryService;
import com.team3.service.IProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements IProductService {

    IProductRepository productRepository;
    ProductMapper productMapper;
    ICloudinaryService cloudinaryService;

    @Override
    public void create(CreateProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        product.setImgUrl(cloudinaryService.uploadFile(productDTO.getFile(), "product"));
        product.setAudioUrl(cloudinaryService.uploadFile(productDTO.getAudioFile(), "audio") + ".mp3");
        productRepository.save(product);
    }

    @Override
    public void update(UpdateProductDTO updateProductDTO) {
        Product product = productMapper.toProduct(updateProductDTO);
        // Product updateProduct = productMapper.updateProduct(updateProductDTO, product);

        if (!updateProductDTO.getFile().isEmpty()) {
            product.setImgUrl(cloudinaryService.uploadFile(updateProductDTO.getFile(), "product"));
        }
        if (!updateProductDTO.getAudioFile().isEmpty()) {
            product.setAudioUrl(cloudinaryService.uploadFile(updateProductDTO.getAudioFile(), "audio") + ".mp3");
        }

        productRepository.save(product);
    }

    @Override
    public List<ProductResponseDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.mapToProductResponseDTO(products);
    }

    @Override
    public Page<Product> getAll(String keyword, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 3);
        if (keyword == null || keyword.equals("")) {
            return productRepository.findAll(pageable);
        }
        List<Product> products = productRepository.findProducts(keyword);
        int start = (int) pageable.getOffset();
        int end = Math.min((int) (pageable.getOffset() + pageable.getPageSize()), products.size());
        products = products.subList(start, end);
        return new PageImpl<>(products, pageable, products.size());
    }

    @Override
    public ProductResponseDTO getById(Long id) {
        return productMapper.toProductResponse(productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found")));
    }

    @Override
    public ProductResponseDTO findBySlug(String slug) {
        return productMapper.toProductResponse(productRepository.findBySlug(slug));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }


}
