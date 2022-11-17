package com.example.paginationserverside.dto;

import com.example.paginationserverside.entity.Car;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {
    private Integer id;
    private String brand;
    private String model;
    private String color;
    private Integer kilometers;

    public CarDTO(Car car, boolean includeAll) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.color = car.getColor();
        this.kilometers = car.getKilometers();
        if(includeAll) {
            this.id = car.getId();
        }
    }
}
