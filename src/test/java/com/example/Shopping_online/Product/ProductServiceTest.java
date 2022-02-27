//package com.example.Shopping_online.Product;
//
//import com.example.Shopping_online.Product.exception.ProductAlreadyExistAuthenticationException;
//import com.example.Shopping_online.User.UserRepository;
//import com.example.Shopping_online.User.UserService;
//import com.example.Shopping_online.User.entity.Account;
//import com.example.Shopping_online.User.exception.UserAlreadyExistAuthenticationException;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//
//    @Mock //อยู่ในส่วนmockito
//    private ProductRepository productRepository;
//
//    @Test
//    void concatData() {
//        //Arrange
//        Product product = new Product(
//                "test",
//                1.0,
//                3,
//                "test");
//
//        when(productRepository.findByName(product.getName())).thenReturn(Optional.of(product));
//        // Act
//        ProductService productService = new ProductService();
//        productService.setProductRepository(productRepository);
//        Product result= productService.concatData(product.getName());
//        //Assert
//        assertEquals(product,result);
//    }
//
//    @Test
//    void addProduct() throws ProductAlreadyExistAuthenticationException {
//        //Arrange
//        Product product = new Product(
//                "test2",
//                1.0,
//                3,
//                "test2");
//
//        when(productRepository.findByName(product.getName())).thenReturn(Optional.of(product));
//        when(productRepository.save(product)).thenReturn(product);
//        // Act
//        ProductService productService = new ProductService();
//        productService.setProductRepository(productRepository);
//        when(productRepository.save(product)).thenReturn(product);
//        Product result= productService.addProduct(product);
//        //Assert
//        assertEquals(product, result);
//    }
//
//    @Test
//    void deleteProduct() {
//        //Arrange
//        Product product = new Product(
//                "test",
//                1.0,
//                3,
//                "test");
//        when(productRepository.findByName(product.getName())).thenReturn(Optional.of(product));
//
//        // Act
//        ProductService productService = new ProductService();
//        productService.setProductRepository(productRepository);
//        productRepository.save(product);
//        Product result= productService.deleteProduct(product.getName());
//        //Assert
//        assertEquals(product,result);
//    }
//
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
//
//}
