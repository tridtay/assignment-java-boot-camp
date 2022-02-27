package com.example.Shopping_online.User.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String name) {
        super(name);
    }
}
