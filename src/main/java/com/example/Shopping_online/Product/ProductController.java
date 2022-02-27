package com.example.Shopping_online.Product;

import com.example.Shopping_online.Product.exception.ProductAlreadyExistAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{name}")
    public ResponseEntity<Product> findProduct(@PathVariable String name)  {
        Product productIn = productService.concatData(name);
        return  new ResponseEntity<Product>(productIn, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductAlreadyExistAuthenticationException {
        Product productIn = productService.addProduct(product);
        return new ResponseEntity<Product>(productIn, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Product> deleteProduct(@PathVariable String name) {
        Product productIn = productService.deleteProduct(name);
        return new ResponseEntity<Product>(productIn, HttpStatus.OK);
    }

    @PutMapping("/update/{name}")
    public  ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable String name) {
        Product productIn = productService.updateProduct(product ,name);
        return  new ResponseEntity<Product>(productIn,HttpStatus.OK);
    }
}
