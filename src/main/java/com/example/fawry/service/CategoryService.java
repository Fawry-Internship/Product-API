package com.example.fawry.service;

import com.example.fawry.entity.Category;
import com.example.fawry.model.category.CategoryRequestDTO;
import com.example.fawry.model.category.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> getAllCategories();
    Category addNewCategory(CategoryRequestDTO categoryRequestDTO);
}
