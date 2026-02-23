package com.cardata.cardatabase00.controller;


import com.cardata.cardatabase00.domain.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepository carRepository;


    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/Cars")
    public
}
