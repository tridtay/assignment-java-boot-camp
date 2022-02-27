package com.example.Shopping_online.cart.exception;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(String name) {
        super(name);
    }
}
