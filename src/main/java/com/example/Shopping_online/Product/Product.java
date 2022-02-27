package com.example.Shopping_online.Product;

import com.example.Shopping_online.cart.Cart;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Data
@Table(name="product")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double price;

    private int quantity;

    private String description;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;


    public Product(String name, double price, int quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Product(String name, double price, int quantity, String description, Cart cart) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }
}
