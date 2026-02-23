package com.cardata.cardatabase00;

import com.cardata.cardatabase00.domain.Car;
import com.cardata.cardatabase00.domain.Owner;
import com.cardata.cardatabase00.domain.CarRepository;
import com.cardata.cardatabase00.domain.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Cardatabase00Application implements CommandLineRunner {
	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;

    public Cardatabase00Application(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }


    public static void main(String[] args) {
		SpringApplication.run(Cardatabase00Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("김", "일");
		Owner owner2 = new Owner("Jane", "Doe");

		ownerRepository.save(owner1);
		ownerRepository.save(owner2);

		Car car1 = new Car("닛산","알티마","124조4021",2022,40000000,owner1);
		Car car2 = new Car("토요타","캠리","83자1942",2018,30000000,owner2);

		carRepository.saveAll(Arrays.asList(car1,car2));

	}
}
