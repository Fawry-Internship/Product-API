package com.example.fawry.service.impl;

import com.example.fawry.entity.Category;
import com.example.fawry.entity.Product;
import com.example.fawry.exception.ConflictException;
import com.example.fawry.exception.RecordNotFoundException;
import com.example.fawry.mapper.ProductMapper;
import com.example.fawry.model.category.CategoryResponseDTO;
import com.example.fawry.model.product.ProductRequestDTO;
import com.example.fawry.model.product.ProductResponseDTO;
import com.example.fawry.repository.ProductRepository;
import com.example.fawry.service.CategoryService;
import com.example.fawry.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;

    public List<ProductResponseDTO> getProducts() {
        List<ProductResponseDTO> allProductResponseDTOS =  productRepository.findAll()
                .stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());

        if(allProductResponseDTOS.isEmpty()){
            log.error("There is no Products!");
            throw new RecordNotFoundException("There is no Product!");
        }

        log.info("All Products : {}", allProductResponseDTOS);
        return allProductResponseDTOS;
    }

    public Product addNewProduct(ProductRequestDTO productRequestDTO) {
        log.info("You want to add This new product : {}", productRequestDTO);
        Optional<Product> productByName = productRepository.findProductByCode(productRequestDTO.getCode());
        System.out.println(productRequestDTO);

        if (productByName.isPresent()){
            log.error("This Product with name: {}, Already Exist!", productRequestDTO.getCode());
            throw new ConflictException("This Product Already Exist!");
        }

        Product newProduct = productMapper.toEntity(productRequestDTO);
        Optional<Category> categoryByName = categoryService.getCategoryByName(productRequestDTO.getCategory_name());
        if (!categoryByName.isPresent()){
            log.error("This Category with name: {}, Not Exist!", productRequestDTO.getCategory_name());
            throw new RecordNotFoundException("This Category Not Exist!");
        }
        newProduct.setCategory(categoryByName.get());

        productRepository.save(newProduct);
        log.info("This new Product added successFully :{}", newProduct);
        return newProduct;
    };

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists){
            throw new RecordNotFoundException("Could not find this Product");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(ProductRequestDTO productRequestDTO) {
        Product product = productRepository.findProductByCode(productRequestDTO.getCode())
                .orElseThrow(() -> new IllegalStateException("Could not find this Product"));

        if(productRequestDTO.getPrice() != null && !Objects.equals(product.getPrice(),productRequestDTO.getPrice())){
            product.setPrice(productRequestDTO.getPrice());
        }

        if(productRequestDTO.getImage_url() != null && !Objects.equals(product.getImage_url(),productRequestDTO.getImage_url())){
            product.setImage_url(productRequestDTO.getImage_url());
        }

        Optional<Category> categoryByName = categoryService.getCategoryByName(productRequestDTO.getCategory_name());
        if (!categoryByName.isPresent()){
            log.error("This Category with name: {}, Not Exist!", productRequestDTO.getCategory_name());
            throw new RecordNotFoundException("This Category Not Exist!");
        }

        product.setBrand(productRequestDTO.getBrand());
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setCategory(categoryByName.get());
        product.setUpdated_at(LocalDate.now());

        productRepository.save(product);
        log.info("Product has been updated successfully:{}", product);
    }
}
