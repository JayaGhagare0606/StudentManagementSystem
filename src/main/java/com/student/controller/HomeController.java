package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.student.service.impl.AdminServiceImpl;
import com.student.service.impl.CityServiceImpl;
import com.student.service.impl.StateServiceImpl;
import com.student.service.impl.StudentServiceImpl;

public class HomeController {
	
	@Autowired
	CityServiceImpl cityService;
	
	@Autowired
	StateServiceImpl stateService;
	
	@Autowired
	AdminServiceImpl adminService;
	
	@Autowired
	StudentServiceImpl studentservice;

}
