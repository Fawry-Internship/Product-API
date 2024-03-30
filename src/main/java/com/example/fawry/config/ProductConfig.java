package com.example.fawry.config;

import com.example.fawry.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    //@Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
     return args -> {
//         Product lenovo = new Product(
//                 "code1",
//                 "lenovo_laptop",
//                 "gaming_laptop",
//                 1000.99,
//                 1,
//                 "lenovo",
//                 "image_url",
//                 LocalDate.of(2024, Month.MARCH, 15),
//                 LocalDate.of(2024, Month.MARCH, 20)
//         );
//
//         Product asus = new Product(
//                 "code2",
//                 "Asus_laptop",
//                 "gaming_laptop",
//                 1000.99,
//                 1,
//                 "Asus",
//                 "image_url",
//                 LocalDate.of(2024, Month.MARCH, 25),
//                 LocalDate.of(2024, Month.MARCH, 29)
//         );
//
//         repository.saveAll(List.of(lenovo, asus));
     };
    }
}
