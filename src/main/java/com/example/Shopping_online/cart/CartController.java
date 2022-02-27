package com.example.Shopping_online.cart;


import com.example.Shopping_online.User.exception.UserNotFoundException;
import com.example.Shopping_online.cart.exception.CartAlreadyExistAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/{name}")
    public ResponseEntity<Cart> addCart(@PathVariable String name) throws UserNotFoundException {
        Cart cartIn = cartService.getCart(name);
        return new ResponseEntity<Cart>(cartIn, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) throws CartAlreadyExistAuthenticationException {
        Cart cartIn = cartService.addCart(cart);
        return new ResponseEntity<Cart>(cartIn, HttpStatus.OK);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart, @PathVariable String name){
        Cart cartIn = cartService.updateCart(cart, name);
        return  new ResponseEntity<Cart>(cartIn, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Cart> deleteCart(@PathVariable String name){
        Cart cartIn = cartService.deleteCart(name);
        return  new ResponseEntity<Cart>(cartIn, HttpStatus.OK);
    }

//    @PutMapping("/addProduct/{cart}/{product}")
//    public  ResponseEntity<Cart> addProductToCart(@PathVariable String cart,@PathVariable String product){
//        Cart cartIn = cartService.addProductToCart(cart, product);
//        return  new ResponseEntity<Cart>(cartIn, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/removeProduct/{cart}/{product}")
//    public  MessageResponse removeProductFromCart(@PathVariable String cart,@PathVariable String product){
//        return  new MessageResponse(cartService.removeProductFromCart(cart, product));
//    }
}