package com.student.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.State;

@RestController
@RequestMapping("/api/State")
public class StateController extends HomeController{
	
	
	@GetMapping("/state-list")
			public List<State> stateList(){
		
		return stateService.stateList();
		
	}
}
