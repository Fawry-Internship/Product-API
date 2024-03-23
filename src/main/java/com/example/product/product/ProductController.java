package com.example.product.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "fawry/product")
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }


    @GetMapping
    public List<Product> getProducts() {
        return productServices.getProducts();
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Product product){
        productServices.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId")Long productId){
        productServices.deleteProduct(productId);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String image_url) {
        productServices.updateProduct(productId, price, image_url);
    }
}
