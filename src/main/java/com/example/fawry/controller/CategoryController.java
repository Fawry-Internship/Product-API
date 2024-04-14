package com.example.fawry.controller;

import com.example.fawry.entity.Category;
import com.example.fawry.model.category.CategoryRequestDTO;
import com.example.fawry.model.category.CategoryResponseDTO;
import com.example.fawry.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "fawry/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<Category> addNewCategory(@RequestBody CategoryRequestDTO categoryRequestDTO){
        return new ResponseEntity<>(categoryService.addNewCategory(categoryRequestDTO), HttpStatus.CREATED);

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
