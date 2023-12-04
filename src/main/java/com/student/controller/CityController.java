package com.student.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.City;

@RestController
@RequestMapping("/api/City")
public class CityController extends HomeController{
	
	@GetMapping("/city-list")
	public List<City> cityList(){
		
		return cityService.cityList();
	}

}
