package com.example.Shopping_online.Product;

//import com.example.Shopping_online.Product.entity.ProductForm;
import com.example.Shopping_online.Product.exception.ProductAlreadyExistAuthenticationException;
import com.example.Shopping_online.Product.exception.ProductNotFoundException;
import com.example.Shopping_online.User.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product concatData(String name) {
        Optional<Product> result = productRepository.findByName(name);
        if (result.isPresent()) {
            return getProductObj(name);
        }
        throw new UserNotFoundException(name);
    }


    public Product addProduct(Product product) throws ProductAlreadyExistAuthenticationException {
        Optional<Product> result = productRepository.findByName(product.getName());
        if (result.isPresent()) {
            throw new ProductAlreadyExistAuthenticationException(product.getName());
        } else {
            productRepository.save(product);
            return product;
        }
    }

    public Product deleteProduct(String name) {
        Optional<Product> result = productRepository.findByName(name);
        if (result.isPresent()) {
            productRepository.deleteById(result.get().getId());
            return getProductObj(name);
        }
        throw new ProductNotFoundException(name);
    }

    public Product updateProduct(Product product, String name) {
        Optional<Product> result = productRepository.findByName(name);
        if (result.isPresent()) {
            product.setId(result.get().getId());
            productRepository.save(product);
            return product;
        } throw new ProductNotFoundException(name);
    }

    public Product getProductObj(String name){
        return productRepository.findByName(name).orElseThrow(() ->
                new ProductNotFoundException(name));
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}

