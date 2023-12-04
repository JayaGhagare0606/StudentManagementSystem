package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.State;

public interface StateRepository extends JpaRepository<State, Integer>{

}
