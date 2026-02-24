package com.korit12.cardatabase;

import com.korit12.cardatabase.domain.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

import java.util.Arrays;


@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);



    public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("애플리케이션이 실행됩니다.");
	}

	// field 선언
	private final CarRepository repository;
	private final OwnerRepository ownerRepository;
	private final AppUserRepository appUserRepository;

	public CardatabaseApplication(CarRepository repository, OwnerRepository ownerRepository, AppUserRepository appUserRepository) {
		this.repository = repository;
		this.ownerRepository = ownerRepository;
		this.appUserRepository = appUserRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("김","일");
		Owner owner2 = new Owner("Jone","Doe");

		ownerRepository.saveAll(Arrays.asList(owner1,owner2));

		repository.save(new Car("현대","소나타", "검정", "123가4567",2026, 30000000, owner1));
		repository.save(new Car("기아","k9", "흰색", "143가4367",2025, 10000000, owner1));
		repository.save(new Car("람보르기니","가야르도", "노랑", "222가4447",2012, 300000000, owner2));

		appUserRepository.save(new AppUser("user","$2a$12$5fIrbFqVCGTY3rukN0YIZ.IJq9IjtA8oNNJLFVFMi0vJhf5d48VRq", "user"));
		appUserRepository.save(new AppUser("admin","$2a$12$IcQCLypBugKdBTkQ4CuBoOniwNpsmJkjPQS84vfszJdZMRydjQfdu","admin"));

	}
}
