package com.anararabli.abbtech.mapper;

import com.anararabli.abbtech.dto.CarDto;
import com.anararabli.abbtech.entity.Car;

public class CarMapper {

    public static Car toEntiy(CarDto carDto) {
        Car car = new Car();
        car.setColor(carDto.getColor());
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());
        return car;
    }

    public static CarDto toDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setColor(car.getColor());
        carDto.setModel(car.getModel());
        carDto.setYear(car.getYear());
        return carDto;
    }
}
