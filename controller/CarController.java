package com.anararabli.abbtech.controller;

import com.anararabli.abbtech.dto.CarDto;
import com.anararabli.abbtech.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDto> getAllCars() {
        return carService.getAllcars();
    }

    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public CarDto createCar(@RequestBody CarDto carDto) {
        return carService.createCar(carDto);
    }
    @PutMapping("/{id}")
    public void updateCar(@PathVariable int id, @RequestBody CarDto carDto) {
        carService.updateCar(id,carDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable int id) {
        try {
            carService.deleteCarById(id);
            return ResponseEntity.ok().body("Car with id " + id + " deleted succes");
        }catch (Exception e) {
            System.out.println("Delete Car with id " + id + " failed");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car with id " + id + " not found");
        }

    }
}
