package com.anararabli.abbtech.service;

import com.anararabli.abbtech.dto.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> getAllcars();
    CarDto getCarById(long id);
    CarDto createCar(CarDto carDto);
    void deleteCarById(int id);
    void updateCar(int id ,CarDto carDto);
}
