package com.example.fawry.mapper;

import com.example.fawry.entity.Category;
import com.example.fawry.model.category.CategoryRequestDTO;
import com.example.fawry.model.category.CategoryResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDTO toDTO(Category category);
    Category toEntity(CategoryRequestDTO categoryRequestDTO);
}
