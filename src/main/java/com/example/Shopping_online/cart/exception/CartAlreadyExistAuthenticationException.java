package com.example.Shopping_online.cart.exception;

import javax.naming.AuthenticationException;

public class CartAlreadyExistAuthenticationException extends AuthenticationException {

    public CartAlreadyExistAuthenticationException(final String msg) {
        super(msg);
    }
}
