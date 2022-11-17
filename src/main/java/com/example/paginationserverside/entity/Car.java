package com.example.paginationserverside.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Car {

    @Id
    private int id;
    private String brand;
    private String model;
    private String color;
    private int kilometers;
}
