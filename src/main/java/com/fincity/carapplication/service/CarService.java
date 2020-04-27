package com.fincity.carapplication.service;

import com.fincity.carapplication.model.Car;

import java.util.List;

public interface CarService {
    public List<Car> getAllCars();

    public Integer saveCar(Car car);

    public void updateCar(Car car) throws Exception;

    public void deleteCar(Integer id) throws Exception;

    public List<Car> findCar(String name, String model, String manufactureName, Integer manufacturingYear, String color);
}
