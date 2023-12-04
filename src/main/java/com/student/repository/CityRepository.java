package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.City;


public interface CityRepository extends JpaRepository<City, Integer>{

}
