package com.example.fawry.controller;

import com.example.fawry.entity.Product;
import com.example.fawry.model.product.ProductRequestDTO;
import com.example.fawry.model.product.ProductResponseDTO;
import com.example.fawry.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "fawry/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public void registerNewProduct(@RequestBody ProductRequestDTO productRequestDTO){
        productService.addNewProduct(productRequestDTO);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId")Long productId){
        productService.deleteProduct(productId);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        productService.updateProduct(productRequestDTO);
    }
}
