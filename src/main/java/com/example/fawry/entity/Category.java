package com.example.fawry.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY ,mappedBy = "category")
    @JsonIgnore
    @ToString.Exclude
    private List<Product> products;

}
