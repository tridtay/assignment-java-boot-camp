package com.example.Shopping_online.Product.exception;

import javax.naming.AuthenticationException;

public class ProductAlreadyExistAuthenticationException extends AuthenticationException {

    public ProductAlreadyExistAuthenticationException(final String msg) {
        super(msg);
    }
}
