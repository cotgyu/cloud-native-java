package com.example.cloudnativejava.chap2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    Long id;

    String email;

    public Customer(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
