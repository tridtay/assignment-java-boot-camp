package com.example.Shopping_online.Product.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String name) {
        super(name);
    }
}
