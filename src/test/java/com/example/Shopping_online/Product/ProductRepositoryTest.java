package com.example.Shopping_online.Product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByName_with_success() {
        // Arrange
        Product product = new Product(
                "test1",
                1.0,
                3,
                "test");

        productRepository.save(product);
        // Act
        Optional<Product> result = productRepository.findByName("test1");
        // Assert
        assertTrue(result.isPresent());
    }

//    @Test
//    void delete_with_success() {
//        // Arrange
//        Product product = new Product(
//                "test",
//                1.0,
//                3,
//                "test");
//        productRepository.save(product);
//        // Act
//        productRepository.delete(product);
//        Optional<Product> result = productRepository.findByName(product.getName());
//        // Assert
//        assertFalse(result.isPresent());
//    }
//
//    @Test
//    void find_by_id(){
//        // Arrange
//        Product product = new Product(
//                "test",
//                1.0,
//                3,
//                "test");
//        productRepository.save(product);
//        // Act
//        Optional<Product> result = productRepository.findById(product.getId());
//        // Assert
//        assertTrue(result.isPresent());
//    }
}
