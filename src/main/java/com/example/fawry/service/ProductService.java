package com.example.fawry.service;

import com.example.fawry.entity.Product;
import com.example.fawry.model.product.ProductRequestDTO;
import com.example.fawry.model.product.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    List<ProductResponseDTO> getProducts();
    String addNewProduct(ProductRequestDTO productRequestDTO);
    String deleteProduct(Long productId);
    String updateProduct(ProductRequestDTO productRequestDTO);

    boolean checkProductAvailability(String productCode);
}
