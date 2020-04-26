package com.fincity.carapplication.controller;

import com.fincity.carapplication.model.Car;
import com.fincity.carapplication.model.Response;
import com.fincity.carapplication.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping("/test")
    public String testMethod() {
        return "Hello World!";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCar(@RequestBody Car car) {
        Integer id = carService.saveCar(car);
        return ResponseEntity.ok(new Response(CREATED, "Car details saved successfully", id));
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateCar(@RequestBody Car car) throws Exception {
        carService.updateCar(car);
        return ResponseEntity.ok(new Response(CREATED, "Car details updated successfully", car.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCar(@PathVariable("id") Integer id) {
        carService.deleteCar(id);
        return ResponseEntity.ok(new Response(NO_CONTENT, "Car deleted successfully"));
    }
}
