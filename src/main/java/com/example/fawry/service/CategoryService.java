package com.example.fawry.service;

import com.example.fawry.model.Category;
import com.example.fawry.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category add(Category category) {
        Optional<Category> categoryByName = categoryRepository.findCategoryByName(category.getName());
        System.out.println(category);

        if (categoryByName.isPresent()){
            throw new IllegalStateException("Category Exist!");
        }
        return categoryRepository.save(category);
    };
}
