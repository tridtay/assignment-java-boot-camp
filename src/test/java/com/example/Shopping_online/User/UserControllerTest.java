package com.example.Shopping_online.User;


import com.example.Shopping_online.MessageResponse;
import com.example.Shopping_online.User.entity.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment=  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private  UserRepository userRepository;


    @Test
    @DisplayName("ส่ง user แล้วจะต้องได้รับข้อความ Register testing Success ")
    void signup() {
        // Arrange
        Account user = new Account("testing",
                "testing",
                "testing",
                "testing",
                "testing");

        MessageResponse result = testRestTemplate.postForObject("/signup", user , MessageResponse.class);

        // Assert verify
        assertEquals( "Register testing Success", result.getMessage());
    }

    @Test
    @DisplayName("ส่ง user แล้วจะต้องได้รับข้อความ Login Success ")
    void login() {
        // Arrange
        Account userLogin = new Account("testing", "testing");
        when(userRepository.findByUsername("testing")).thenReturn(Optional.of(userLogin));
        //Act
        MessageResponse result = testRestTemplate.postForObject("/login", userLogin, MessageResponse.class);

        // Assert verify
        assertEquals("Login Success", result.getMessage());
    }
}
