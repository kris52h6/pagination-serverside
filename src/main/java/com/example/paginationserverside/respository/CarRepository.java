package com.example.paginationserverside.respository;

import com.example.paginationserverside.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Page<Car> findAllByBrand(@PathVariable String brand, Pageable p);
    Page<Car> findAllBy(@PathVariable String column, @PathVariable String value, Pageable p);
}
