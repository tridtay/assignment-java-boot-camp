/*
package com.example.Shopping_online.User;


import com.example.Shopping_online.User.entity.Account;
import com.example.Shopping_online.User.exception.UserAlreadyExistAuthenticationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void Register() throws UserAlreadyExistAuthenticationException {
        // Arrange
        Account user = new Account("testing",
                "testing",
                "testing",
                "testing",
                "testing");

        when(userRepository.findByUsername("testing")).thenReturn(Optional.of(user));
        // Act
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);;
        String result = userService.register(user);
        // Assert
        assertEquals("Register testing Success", result);
    }
}
 */