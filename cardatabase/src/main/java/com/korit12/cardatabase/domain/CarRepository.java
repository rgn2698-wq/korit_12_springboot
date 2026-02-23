package com.korit12.cardatabase.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    // CrudRepository에 있는 메서드라면 여기에 정리를 해줘야 함.

    List<Car> findByBrand(String brand);

    // 색상으로 검색, 그리고 연도로 검색하는 메서드를 직접 정의
    List<Car> findByColor(String color);
    List<Car> findByModelYear(int modelYear);

    // SQL 상에서의 AND 및 OR 연산자도 적용이됨.
    // 브랜드의 모델로 자동차 검색
    List<Car> findByBrandAndModel(String brand, String model);

    // 브랜드 또는 색상별로 자동차 가져오기
    List<Car> findByBrandOrColor(String brand, String color);

    List<Car> findByBrandOrderByModelYearAsc(String brand);

    // @Query 에너테이션을 사용

    @Query("Select c from Car c where c.model = ?1")
    List<Car> findByModel(String model);
    // 그런데 이상의 경우에는 일치하는 것만 구할수가있는데, @query를 쓰는 이유는 LIKE 연산자를 쓸수 있기 때문

    @Query("Select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndWith(String brand);

    // 다만 @Query를 쓰게 되면 다른 데이터베이스로의 이식성이 좀 떨어짐.
}
