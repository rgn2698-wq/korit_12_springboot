package com.temp.springbootstudy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;

    public AppUser() {}

    private String name, username, password;



    public AppUser(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
