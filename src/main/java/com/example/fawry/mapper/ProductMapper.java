package com.example.fawry.mapper;

import com.example.fawry.entity.Product;
import com.example.fawry.model.product.ProductRequestDTO;
import com.example.fawry.model.product.ProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
        @Mapping(target = "categoryName" , source = "category.name")
        ProductResponseDTO toDTO(Product product);
        @Mapping(target = "category" , ignore = true)
        Product toEntity(ProductRequestDTO productRequestDTO);
}
