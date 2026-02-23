package com.cardata.cardatabase00.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String last_name;

    public Owner() {
    }
    @OneToMany(cascade =  CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Owner(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getId() {
        return id;
    }
}
