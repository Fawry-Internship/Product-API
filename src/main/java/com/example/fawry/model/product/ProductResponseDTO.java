package com.example.fawry.model.product;

import com.example.fawry.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Double price;
    private String category_name;
    private String brand;
    private String image_url;
    private LocalDate created_at;
    private LocalDate updated_at;
}
