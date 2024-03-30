package com.example.fawry.service;

import com.example.fawry.model.Product;
import com.example.fawry.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServices {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        Optional<Product> productByCode = productRepository.findProductByCode(product.getCode());
        System.out.println(product);

        if (productByCode.isPresent()){
            throw new IllegalStateException("Duplicated Code");
        }
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
    }
}
