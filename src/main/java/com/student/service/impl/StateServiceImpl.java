package com.student.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.student.model.State;
import com.student.service.StateService;

@Service
public class StateServiceImpl extends HomeService implements StateService {

	@Override
	public List<State> stateList() {
		// TODO Auto-generated method stub
		return stateRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
	}

}
