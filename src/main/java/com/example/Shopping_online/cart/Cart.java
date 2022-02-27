package com.example.Shopping_online.cart;

import com.example.Shopping_online.Product.Product;
import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(
            mappedBy = "cart"
    )
    private List<Product> products = new ArrayList<Product>();

    public Cart() {
    }

    public Cart(String name) {
        this.name = name;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product  product){
        products.remove(product);
    }

}



