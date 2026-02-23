package com.cardata.cardatabase00.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "car")

@JsonIgnoreProperties()
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String brand;

    private String model;

    private String registrationNumber;

    private int modelYear;

    private int price;

    @ManyToOne
    @JoinColumn(name = "owners", nullable = false)
    private Owner owner;

    public Car() {
    }

    public Car(String brand, String model, String registrationNumber, int modelYear, int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner( Owner owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }
}
