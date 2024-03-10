package com.team3.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private int price;
    private String description;
    private String audioUrl;
    private String imgUrl;
    private MultipartFile file; // File hình ảnh
}
