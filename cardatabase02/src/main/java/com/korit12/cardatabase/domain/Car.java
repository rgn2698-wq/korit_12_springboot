package com.korit12.cardatabase.domain;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;


@Entity
// Lombok을 의존성 주입하고 Car클래스를 롬복적용 버전으로 다 수정
// 이후 동일하게 Localhost:8080/h2-console을 통해서 접속에 성공

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NonNull
    private String brand;
    @NonNull
    private String model;
    @NonNull
    private String color;
    @NonNull
    private String registrationNumber;
    @Nonnull
    private int modelYear;
    @NonNull
    private int price;

    @ManyToOne
    @JoinColumn(name = "owner")
    @NonNull
    private Owner owner;

}
