package com.anararabli.abbtech.service.impl;


import com.anararabli.abbtech.config.CourseConfig;
import com.anararabli.abbtech.dto.CarDto;
import com.anararabli.abbtech.entity.Car;
import com.anararabli.abbtech.exception.BaseErrorEnum;
import com.anararabli.abbtech.exception.CarException;
import com.anararabli.abbtech.mapper.CarMapper;
import com.anararabli.abbtech.repository.CarRepository;
import com.anararabli.abbtech.service.CarService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Profile("local")
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    @Value("${course.name}")
    private String courseName;

    private final CourseConfig courseConfig;

    private final Environment environment;

    @Value("${course.students}")
    private List<String> students;

    public CarServiceImpl(CarRepository carRepository, CourseConfig courseConfig, Environment environment) {

        this.carRepository = carRepository;
        this.courseConfig = courseConfig;
        this.environment = environment;
    }


    @Override
    public List<CarDto> getAllcars() {

        environment.getProperty("course.name");
        throw new CarException(BaseErrorEnum.BASE_BUSINESS_ERROR);
//        return carRepository.findAll()
//                .stream()
//                .map(CarMapper :: toDto)
//                .toList();
        //       throw new CarException(CarErrorEnum.CAR_NOT_FOUND);


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
