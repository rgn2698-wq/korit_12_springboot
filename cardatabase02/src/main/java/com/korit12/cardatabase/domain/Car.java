package com.korit12.cardatabase.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;


@Entity
// Lombok을 의존성 주입하고 Car클래스를 롬복적용 버전으로 다 수정
// 이후 동일하게 Localhost:8080/h2-console을 통해서 접속에 성공

@Schema(description = "자동차 엔티티 모델")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "자동 생성되는 고유 ID", example = "1")
    private Long Id;

    @NonNull
    @Schema(description = "브랜드", example = "현대")
    private String brand;
    @NonNull
    @Schema(description = "자동차 모델", example = "펠리셰이드")
    private String model;
    @NonNull
    @Schema(description = "자동차 색상", example = "빨강")
    private String color;
    @NonNull
    @Schema(description = "자동차 등록번호", example = "123가4567")
    private String registrationNumber;
    @Nonnull
    @Schema(description = "자동차 연식", example = "2026")
    private int modelYear;
    @NonNull
    @Schema(description = "자동차 가격", example = "10000000")
    private int price;

    @ManyToOne
    @JoinColumn(name = "owner")
    @NonNull
    private Owner owner;

}
