package com.example.Shopping_online.Cart;


import com.example.Shopping_online.Product.Product;
import com.example.Shopping_online.Product.ProductRepository;
import com.example.Shopping_online.cart.Cart;
import com.example.Shopping_online.cart.CartRepository;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Test
    void findByName_with_success() {
        // Arrange
        Cart cart1 = new Cart("test");

        cartRepository.save(cart1);
        // Act
        Optional<Cart> result = cartRepository.findByName("test");
        // Assert
        assertTrue(result.isPresent());
    }
}
