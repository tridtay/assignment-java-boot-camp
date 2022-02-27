package com.example.Shopping_online.Cart;

import com.example.Shopping_online.cart.Cart;
import com.example.Shopping_online.cart.CartRepository;
import com.example.Shopping_online.cart.CartService;
import com.example.Shopping_online.cart.exception.CartAlreadyExistAuthenticationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @Test
    void getCart() {
        //Arrange
        Cart cart1 = new Cart("test");

        when(cartRepository.findByName(cart1.getName())).thenReturn(Optional.of(cart1));
        // Act
        CartService cartService = new CartService();
        cartService.setCartRepository(cartRepository);
        Cart result= cartService.getCart(cart1.getName());
        //Assert
        assertEquals(cart1,result);
    }

//    @Test
//    void addCart() throws CartAlreadyExistAuthenticationException {
//        //Arrange
//        Cart cart1 = new Cart("test");
//
//        when(cartRepository.findByName(cart1.getName())).thenReturn(Optional.of(cart1));
//        when(cartRepository.save(cart1)).thenReturn(cart1);
//        // Act
//        CartService cartService = new CartService();
//        cartService.setCartRepository(cartRepository);
//        when(cartRepository.save(cart1)).thenReturn(cart1);
//        Cart result= cartService.addCart(cart1);
//        //Assert
//        assertEquals(cart1, result);
//    }

    @Test
    void deleteProduct() {
        //Arrange
        Cart cart1 = new Cart("test");
        when(cartRepository.findByName(cart1.getName())).thenReturn(Optional.of(cart1));
        // Act
        CartService cartService = new CartService();
        cartService.setCartRepository(cartRepository);
        Cart result= cartService.getCart(cart1.getName());
        //Assert
        assertEquals(cart1,result);
    }

//    @Test
//    void updateProduct() {
//        //Arrange
//        Product product1 = new Product(
//                "test",
//                1.0,
//                3,
//                "test");
//
//        Product product2 = new Product(
//                "test2",
//                1.0,
//                3,
//                "test2");
//
//        when(productRepository.findByName(product2.getName())).thenReturn(Optional.of(product2));
//
//        // Act
//        ProductService productService = new ProductService();
//        productService.setProductRepository(productRepository);
//        productRepository.save(product1);
//        Product result= productService.updateProduct(product2, product1.getName());
//        //Assert
//        assertEquals(product2,result);
//    }
}
