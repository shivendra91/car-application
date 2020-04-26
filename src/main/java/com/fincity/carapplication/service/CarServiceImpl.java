package com.fincity.carapplication.service;

import com.fincity.carapplication.entity.CarEntity;
import com.fincity.carapplication.model.Car;
import com.fincity.carapplication.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Car> getAllCars() {
        List<CarEntity> carEntities = carRepository.findAll();
        List<Car> carList = new ArrayList();
        carEntities.forEach(carEntity -> carList.add(modelMapper.map(carEntity, Car.class)));
        return carList;
    }

    @Override
    public Integer saveCar(Car car) {
        CarEntity carEntity = modelMapper.map(car, CarEntity.class);
        Integer id = carRepository.save(carEntity).getId();
        return id;
    }

    @Override
    public void updateCar(Car car) throws Exception {
        Optional<CarEntity> carEntity = carRepository.findById(car.getId());
        if (!carEntity.isPresent())
            throw new Exception("Car not found");
        CarEntity carUpdate = modelMapper.map(car, CarEntity.class);
        carRepository.save(carUpdate);
    }

    @Override
    public void deleteCar(Integer id) {

    }
}
