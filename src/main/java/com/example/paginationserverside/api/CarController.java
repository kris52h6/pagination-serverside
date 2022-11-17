package com.example.paginationserverside.api;

import com.example.paginationserverside.dto.CarDTO;
import com.example.paginationserverside.entity.Car;
import com.example.paginationserverside.service.CarService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/cars")
@CrossOrigin
public class CarController {

    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDTO> getCars(Pageable p) {
        return carService.getCars(p);
    }

    @GetMapping("/brand/{brand}")
    public List<CarDTO> getCarsByBrand(@PathVariable String brand, Pageable p) {
        System.out.println(brand);
        return carService.getCarsByBrand(brand, p);
    }

    /*@GetMapping("/filter/column={column}&value={value}")
    public List<CarDTO> getCarsByFilterType(@PathVariable String column, @PathVariable String value, Pageable p) {
        return carService.getCarsByFilterType(column, value, p);
    }*/


}
