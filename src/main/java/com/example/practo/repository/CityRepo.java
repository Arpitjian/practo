package com.example.practo.repository;

import com.example.practo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  CityRepo extends JpaRepository<City,Long> {
    List<City> findByStateId(Long stateId);
}
