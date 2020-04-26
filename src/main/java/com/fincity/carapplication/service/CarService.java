package com.fincity.carapplication.service;

import com.fincity.carapplication.model.Car;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CarService {
    public List<Car> getAllCars();

    public Integer saveCar(Car car);

    public void updateCar(Car car) throws Exception;

    public void deleteCar(Integer id);
}
