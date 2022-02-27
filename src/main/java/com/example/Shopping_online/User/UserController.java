package com.example.Shopping_online.User;

import com.example.Shopping_online.User.entity.Account;
import com.example.Shopping_online.User.exception.UserAlreadyExistAuthenticationException;
import com.example.Shopping_online.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public MessageResponse signup(@RequestBody Account account) throws UserAlreadyExistAuthenticationException {
        return new MessageResponse(userService.register(account));
    }

    @PostMapping("/login")
    public MessageResponse login(@RequestBody Account account) throws UserAlreadyExistAuthenticationException {
        return new MessageResponse(userService.login(account));
    }
    }
