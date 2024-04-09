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
    private String categoryName;
    private String brand;
    private String imageUrl;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
