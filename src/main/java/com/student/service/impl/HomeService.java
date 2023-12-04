package com.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.student.repository.AdminRepository;
import com.student.repository.CityRepository;
import com.student.repository.StateRepository;
import com.student.repository.StudentRepository;



public class HomeService {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;

}
