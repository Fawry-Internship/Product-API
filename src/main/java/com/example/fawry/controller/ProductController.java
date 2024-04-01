package com.example.fawry.controller;

import com.example.fawry.entity.Product;
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
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Product product){
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId")Long productId){
        productService.deleteProduct(productId);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String image_url) {
        productService.updateProduct(productId, price, image_url);
    }
}
