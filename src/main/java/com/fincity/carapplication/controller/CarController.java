package com.fincity.carapplication.controller;

import com.fincity.carapplication.entity.CarEntity;
import com.fincity.carapplication.model.Car;
import com.fincity.carapplication.model.Response;
import com.fincity.carapplication.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

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
        try {
            carService.updateCar(car);
            return ResponseEntity.ok(new Response(CREATED, "Car details updated successfully", car.getId()));
        } catch (Exception ex) {
            return ResponseEntity.ok(new Response(NOT_FOUND, ex.getMessage(), car.getId()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCar(@PathVariable("id") Integer id) throws Exception {
        try {
            carService.deleteCar(id);
            return ResponseEntity.ok(new Response(NO_CONTENT, "Car deleted successfully", id));
        } catch (Exception ex) {
            return ResponseEntity.ok(new Response(NOT_FOUND, ex.getMessage(), id));
        }
    }

    @GetMapping("/find")
    public ResponseEntity<List<CarEntity>> findCars(@RequestParam(value = "name", required = false) String name,
                                                    @RequestParam(value = "model", required = false) String model,
                                                    @RequestParam(value = "manufactureName", required = false) String manufactureName,
                                                    @RequestParam(value = "color", required = false) String color,
                                                    @RequestParam(value = "manufacturingYear", required = false) Integer manufacturingYear) {
        return ResponseEntity.ok(carService.findCar(name, model, manufactureName, manufacturingYear, color));

    }
}
