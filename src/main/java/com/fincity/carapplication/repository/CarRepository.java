package com.fincity.carapplication.repository;

import com.fincity.carapplication.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findByNameAndManufactureNameAndModelAndManufacturingYearAndColor(String name, String manufactureName,
                                                                                     String model, Integer manufacturingYear, String color);

    List<CarEntity> findByName(String name);

    List<CarEntity> findByModel(String name);

    List<CarEntity> findByManufactureName(String name);

    List<CarEntity> findByManufacturingYear(Integer manufacturingYear);

    List<CarEntity> findByColor(String color);
}
