package com.example.Shopping_online.User;


import com.example.Shopping_online.User.entity.Account;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private  UserRepository userRepository;

    @Test
    void findByName_with_success() {
        // Arrange
        Account user = new Account("testing",
                "testing",
                "testing",
                "testing",
                "testing");;
        userRepository.save(user);
        // Act
        Optional<Account> result = userRepository.findByUsername("testing");
        // Assert
        assertTrue(result.isPresent());
    }
}
