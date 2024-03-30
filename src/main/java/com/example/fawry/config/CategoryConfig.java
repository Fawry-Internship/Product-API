package com.example.fawry.config;

import com.example.fawry.model.Category;
import com.example.fawry.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfig {

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository repository){
     return args -> {
         Category laptop = new Category(
                 "Laptop",
                 "Laptop"

         );

         Category phone = new Category(
                 "Smart Phone",
                 "Smart Phone"


         );

         repository.saveAll(List.of(laptop, phone));
     };
    }
}
