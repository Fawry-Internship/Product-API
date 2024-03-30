package com.example.fawry.controller;

import com.example.fawry.model.Category;
import com.example.fawry.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "fawry/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    public Category add(@RequestBody Category Category){
        return categoryService.add(Category);

    }

//    @DeleteMapping(path = "{CategoryId}")
//    public void deleteCategory(@PathVariable("CategoryId")Long CategoryId){
//        categoryService.deleteCategory(CategoryId);
//    }
//
//    @PutMapping(path = "{CategoryId}")
//    public void updateCategory(
//            @PathVariable("CategoryId") Long CategoryId,
//            @RequestParam(required = false) Double price,
//            @RequestParam(required = false) String image_url) {
//        categoryService.updateCategory(CategoryId, price, image_url);
//    }
}
