package com.example.fawry.controller;

import com.example.fawry.entity.Product;
import com.example.fawry.model.product.ProductRequestDTO;
import com.example.fawry.model.product.ProductResponseDTO;
import com.example.fawry.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "fawry/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<String> registerNewProduct(@RequestBody ProductRequestDTO productRequestDTO){
        return new ResponseEntity<>(productService.addNewProduct(productRequestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId")Long productId){
        return new ResponseEntity<>(productService.deleteProduct(productId), HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return new ResponseEntity<>(productService.updateProduct(productRequestDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{productCode}/availability")
    public ResponseEntity<Boolean> checkProductAvailability(@PathVariable String productCode) {
        boolean isAvailable = productService.checkProductAvailability(productCode);
        return ResponseEntity.ok(isAvailable);
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductResponseDTO> findProductById(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.findProductById(productId));
    }
}
