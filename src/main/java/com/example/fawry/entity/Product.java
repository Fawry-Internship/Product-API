package com.example.fawry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String brand;
    private String image_url;
    private LocalDate created_at;
    private LocalDate updated_at;
}
