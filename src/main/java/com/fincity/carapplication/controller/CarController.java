package com.fincity.carapplication.controller;

import com.fincity.carapplication.model.Car;
import com.fincity.carapplication.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/save")
    public void saveCar(@RequestBody Car car) {
        carService.saveCar(car);
    }

    @PutMapping("/update")
    public void updateCar(@RequestBody Car car) {
        carService.updateCar(car);
    }

    @DeleteMapping("/delete")
    public void deleteCar(@RequestParam("id") Integer id) {
        carService.deleteCar(id);
    }
}
