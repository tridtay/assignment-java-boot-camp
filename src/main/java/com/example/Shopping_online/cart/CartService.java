package com.example.Shopping_online.cart;

import com.example.Shopping_online.Product.ProductRepository;
import com.example.Shopping_online.Product.ProductService;
import com.example.Shopping_online.User.exception.UserNotFoundException;

import com.example.Shopping_online.cart.exception.CartAlreadyExistAuthenticationException;
import com.example.Shopping_online.cart.exception.CartNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;


    public Cart getCart(String name) throws UserNotFoundException {
        Optional<Cart> result = cartRepository.findByName(name);
        if(result.isPresent()){
            return getCartObject(name);
        } throw new UserNotFoundException(name);
    }

    public Cart addCart(Cart cart) throws CartAlreadyExistAuthenticationException {
        Optional<Cart> result = cartRepository.findByName(cart.getName());
        if(result.isPresent()){
            throw new CartAlreadyExistAuthenticationException(cart.getName());
        } else {
            cartRepository.save(cart);
            return cart;
        }
    }

    public Cart deleteCart(String name) {
        Optional<Cart> result = cartRepository.findByName(name);
        if (result.isPresent()) {
            cartRepository.deleteById(result.get().getId());
            return getCartObject(name);
        } throw new CartNotFoundException(name);
    }

    public Cart updateCart(Cart cart, String name) {
        Optional<Cart> result = cartRepository.findByName(name);
        if (result.isPresent()) {
            cart.setId(result.get().getId());
            cartRepository.save(cart);
            return cart;
        } throw new CartNotFoundException(name);
    }

//    @Transactional
//    public  Cart addProductToCart(String cart,String product){
//        Cart cartobj = getCartObject(cart);
//        Product productobj = productService.getProductObj(product);
//        if (cartobj != null) {
//            if(productobj != null){
//                cartobj.addProduct(productobj);
//                productobj.setCart(cartobj);
//                return cartobj;
//            }
//        } throw new CartNotFoundException(cart);
//    }
//
//    @Transactional
//    public  String removeProductFromCart(String cart, String product){
//        Optional<Cart> resultCart = cartRepository.findByName(cart);
//        Cart cartObj = getCartObject(cart);
//        Product productObj = productService.getProductObj(product);
//        if (resultCart.isPresent()){
//            cartObj.removeProduct(productObj);
//            return "Remove  " + product + " Success";
//        } throw new CartNotFoundException(cart);
//    }

    public Cart getCartObject(String name){
        return cartRepository.findByName(name).orElseThrow(() ->
                new CartNotFoundException(name));
    }

    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
}
