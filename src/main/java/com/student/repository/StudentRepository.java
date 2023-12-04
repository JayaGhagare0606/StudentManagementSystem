package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
		
	public List<Student> findByName(String name);
	
	public Student findByDob(String dob);
	
	public Student findByPhone(String phone);
	
	public Student findByRollnumber(String rollnumber);
	
}
