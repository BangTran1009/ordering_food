package com.team3.dto.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class  UpdateProductDTO {
    Long id;
    String name;
    String slug;
    int price;
    String description;
    String audioUrl;
    String imgUrl;
    MultipartFile audioFile;
    MultipartFile file;
}
