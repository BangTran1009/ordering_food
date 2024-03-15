package com.team3.dto.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductDTO {
    String name;
    String slug;
    int price;
    String description;
    MultipartFile audioFile;
    MultipartFile file;
}