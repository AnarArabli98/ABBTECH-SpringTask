package com.anararabli.abbtech.service;


import com.anararabli.abbtech.dto.CarDto;
import com.anararabli.abbtech.entity.Car;
import com.anararabli.abbtech.mapper.CarMapper;
import com.anararabli.abbtech.repository.CarRepository;
import com.anararabli.abbtech.service.impl.CarServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements CarServiceImpl {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<CarDto> getAllcars() {
        return carRepository.findAll()
                .stream()
                .map(CarMapper :: toDto)
                .toList();
    }

    @Override
    public CarDto getCarById(long id) {
        Car car =  carRepository.findById(id);
        return car == null ? null : CarMapper.toDto(car);
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = CarMapper.toEntiy(carDto);
        carRepository.save(car);
        return CarMapper.toDto(car);
    }

    @Override
    public void deleteCarById(int id) {
        Car  car = carRepository.findById(id);
        if(car == null){
            throw new RuntimeException("Car with id " + id + " not found");
        }
        carRepository.delete(id,car);
    }

    @Override
    public void updateCar(int id, CarDto carDto) {
        Car updated = CarMapper.toEntiy(carDto);
        carRepository.update(id,updated);
    }
}
