//package com.example.Shopping_online.Product;
//
//import com.example.Shopping_online.MessageResponse;
//import com.example.Shopping_online.User.UserRepository;
//import com.example.Shopping_online.User.entity.Account;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(webEnvironment=  SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ProductControllerTest {
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    @MockBean
//    private ProductRepository productRepository;
//
//    @Test
//    void findProduct() {
//        // Arrange
//        Account user = new Account("testing",
//                "testing",
//                "testing",
//                "testing",
//                "testing");
//
//        MessageResponse result = testRestTemplate.getForObject("/product/user", user , ResponseEntity<Product>);
//
//        // Assert verify
//        assertEquals( , result.getMessage());
//    }
//}
