package com.example.paginationserverside.service;

import com.example.paginationserverside.dto.CarDTO;
import com.example.paginationserverside.entity.Car;
import com.example.paginationserverside.respository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDTO> getCars(Pageable pageable) {
        Page<Car> listOfCars = carRepository.findAll(pageable);
        return listOfCars.stream().map(car -> new CarDTO(car, true)).collect(Collectors.toList());
    }

    public List<CarDTO> getCarsByBrand(@PathVariable String brand, Pageable p) {
        Page<Car> listOfCarsByBrand = carRepository.findAllByBrand(brand, p);
        return listOfCarsByBrand.stream().map(car -> new CarDTO(car, true)).collect(Collectors.toList());
    }

    public List<CarDTO> getCarsByFilterType(@PathVariable String column, @PathVariable String value, Pageable p) {
        Page<Car> listOfCarsByFilter = carRepository.findAllBy(column, value, p);
        return listOfCarsByFilter.stream().map(car -> new CarDTO(car, true)).toList();
    }
}
