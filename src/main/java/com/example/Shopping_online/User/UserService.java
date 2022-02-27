package com.example.Shopping_online.User;



import com.example.Shopping_online.User.entity.Account;
import com.example.Shopping_online.User.exception.UserAlreadyExistAuthenticationException;
import com.example.Shopping_online.User.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean concatData(String username) {
        Optional<Account> result = userRepository.findByUsername(username);
        if (result.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public String register(Account account) throws UserAlreadyExistAuthenticationException {
        Optional<Account> result = userRepository.findByUsername(account.getUsername());
        if (result.isPresent()) {
            throw new UserAlreadyExistAuthenticationException(account.getUsername());
        } else {
            userRepository.save(account);
            return "Register " + account.getUsername() + " Success";
        }

    }

    public String login(Account account) throws UserNotFoundException {
        Optional<Account> result = userRepository.findByUsername(account.getUsername());
        if (concatData(account.getUsername())){
            if(result.get().getPassword().equals(account.getPassword())){
                return "Login Success";
            }else {
                return "Wrong password";
            }
        }throw new UserNotFoundException(account.getUsername());
    }

    public void setUserRepository(UserRepository userRepository) {
    }

}
