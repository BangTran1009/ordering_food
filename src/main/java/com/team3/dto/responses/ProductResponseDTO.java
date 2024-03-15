package com.team3.dto.responses;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDTO {
    Long id;
    String name;
    String slug;
    int price;
    String description;
    String audioUrl;
    String imgUrl;
}
