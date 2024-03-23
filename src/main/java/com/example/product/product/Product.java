package com.example.product.product;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )

    private Long id;
    private String code;
    private String name;
    private String description;
    private Double price;
    private Long category_id;
    private String brand;
    private String image_url;
    private LocalDate created_at;
    private LocalDate updated_at;

    public Product() {
    }

    public Product(Long id,
                   String code,
                   String name,
                   String description,
                   Double price,
                   Long category_id,
                   String brand,
                   String image_url) {

        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category_id = category_id;
        this.brand = brand;
        this.image_url = image_url;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Product( String code,
                   String name,
                   String description,
                   Double price,
                   Long category_id,
                   String brand,
                   String image_url,
                   LocalDate created_at,
                   LocalDate updated_at) {

        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category_id = category_id;
        this.brand = brand;
        this.image_url = image_url;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }
}
