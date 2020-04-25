package com.fincity.carapplication.service;

import com.fincity.carapplication.model.Car;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CarService {
    public List<Car> getAllCars();

    public void saveCar(Car car);

    public void updateCar(Car car);

    public void deleteCar(Integer id);
}
