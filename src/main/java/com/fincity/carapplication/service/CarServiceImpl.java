package com.fincity.carapplication.service;

import com.fincity.carapplication.entity.CarEntity;
import com.fincity.carapplication.model.Car;
import com.fincity.carapplication.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public void saveCar(Car car) {

    }

    @Override
    public void updateCar(Car car) {

    }

    @Override
    public void deleteCar(Integer id) {

    }
}
