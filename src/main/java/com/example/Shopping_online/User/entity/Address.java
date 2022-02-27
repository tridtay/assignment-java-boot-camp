package com.example.Shopping_online.User.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "streetAddress", nullable = false)
    private  String streetAddress;

    @Column(name = "suite", nullable = false)
    private  String suite;

    @Column(name = "city", nullable = false)
    private  String city;

    @Column(name = "country", nullable = false)
    private  String country;

    @Column(name = "Zip", nullable = false)
    private  String Zip;

    @OneToOne(mappedBy = "address")
    private  Account account;
}
