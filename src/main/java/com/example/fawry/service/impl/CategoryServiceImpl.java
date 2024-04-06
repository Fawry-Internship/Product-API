package com.example.fawry.service.impl;

import com.example.fawry.entity.Category;
import com.example.fawry.exception.ConflictException;
import com.example.fawry.exception.RecordNotFoundException;
import com.example.fawry.mapper.CategoryMapper;
import com.example.fawry.model.category.CategoryRequestDTO;
import com.example.fawry.model.category.CategoryResponseDTO;
import com.example.fawry.repository.CategoryRepository;
import com.example.fawry.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    public List<CategoryResponseDTO> getAllCategories() {
        List<CategoryResponseDTO> allCategoryResponseDTOS =  categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());

        if(allCategoryResponseDTOS.isEmpty()){
            log.error("There is no Categories!");
            throw new RecordNotFoundException("There is no Categories!");
        }

        log.info("All Categories : {}", allCategoryResponseDTOS);
        return allCategoryResponseDTOS;
    }

    public Category addNewCategory(CategoryRequestDTO categoryRequestDTO) {
        log.info("You want to add This new category : {}", categoryRequestDTO);
        Optional<Category> categoryByName = categoryRepository.findCategoryByName(categoryRequestDTO.getName());
        System.out.println(categoryRequestDTO);

        if (categoryByName.isPresent()){
            log.error("This Category with name: {}, Already Exist!", categoryRequestDTO.getName());
            throw new ConflictException("This Category Already Exist!");
        }

        Category newCategory = categoryMapper.toEntity(categoryRequestDTO);
        categoryRepository.save(newCategory);
        log.info("This new Category added successFully :{}", newCategory);
        return newCategory;
    };

    public  Optional<Category> getCategoryByName(String name){
        return categoryRepository.findCategoryByName(name);
    }
}
