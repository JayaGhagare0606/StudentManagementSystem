package com.student.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.student.model.City;
import com.student.service.CityService;

@Service
public class CityServiceImpl extends HomeService implements CityService {

	@Override
	public List<City> cityList() {
		// TODO Auto-generated method stub
		return cityRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
	} 

}
