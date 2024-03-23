package com.example.product.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
     return args -> {
         Product lenovo = new Product(
                 "code1",
                 "lenovo_laptop",
                 "gaming_laptop",
                 1000.99,
                 2L,
                 "lenovo",
                 "image_url",
                 LocalDate.of(2024, Month.MARCH, 15),
                 LocalDate.of(2024, Month.MARCH, 20)
         );

         Product asus = new Product(
                 "code2",
                 "Asus_laptop",
                 "gaming_laptop",
                 1000.99,
                 2L,
                 "Asus",
                 "image_url",
                 LocalDate.of(2024, Month.MARCH, 25),
                 LocalDate.of(2024, Month.MARCH, 29)
         );

         repository.saveAll(List.of(lenovo, asus));
     };
    }
}
