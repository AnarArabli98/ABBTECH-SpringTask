package com.anararabli.abbtech.repository;

import com.anararabli.abbtech.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {

    private List<Car> cars  = new ArrayList<>();
    private int index = 1;

    public List<Car> findAll() {
        return cars;
    }
    public Car findById(long id) {
        return cars.stream()
                .filter(c-> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public Car save(Car car) {
        car.setId(index++);
        cars.add(car);
        return car;
    }
    public void delete(int id , Car car) {
        Car existing = findById(id);
        if(existing != null) {
            cars.remove(existing);
        }else  {
            System.out.println("Car Not Found");
        }
    }
    public void update(int id , Car car) {
        Car existing = findById(id);
        if(existing != null) {
            existing.setModel(car.getModel());
            existing.setYear(car.getYear());
            existing.setColor( car.getColor());
            existing.setId( car.getId() );

        }
    }

}
