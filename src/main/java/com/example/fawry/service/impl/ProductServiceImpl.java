package com.example.fawry.service.impl;

import com.example.fawry.entity.Product;
import com.example.fawry.exception.ConflictException;
import com.example.fawry.repository.ProductRepository;
import com.example.fawry.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        Optional<Product> productByCode = productRepository.findProductByCode(product.getCode());
        System.out.println(product);

        if (productByCode.isPresent()){
            throw new ConflictException("This Product Already Exists!");
        }

        product.setCreated_at(LocalDate.now());
        productRepository.save(product);
    };

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists){
            throw new IllegalStateException("Could not find this Product");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, Double price, String image_url) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("Could not find this Product"));

        if(price != null && !Objects.equals(product.getPrice(),price)){
            product.setPrice(price);
        }

        if(image_url != null && !Objects.equals(product.getImage_url(),image_url)){
            product.setImage_url(image_url);
        }

        product.setUpdated_at(LocalDate.now());
    }
}
