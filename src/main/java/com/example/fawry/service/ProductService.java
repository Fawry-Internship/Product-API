package com.example.fawry.service;

import com.example.fawry.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    void addNewProduct(Product product);
    void deleteProduct(Long productId);
    void updateProduct(Long productId, Double price, String image_url);
}
