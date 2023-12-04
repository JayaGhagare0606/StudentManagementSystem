package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {

	public List<Student> studentList();
	
	public String addStudent(Student student);
	
	public Student findStudentById(int id);
	
	public String updateStudent(int id, Student student);
	
	public String deleteStudent(int id);
	
	public List<Student> studentname(String name);
	
	public Student findByDob(String dob);
	
	public Student findByPhone(String phone);
	
	public Student findByRollnumber(String rollnmber);
	
	
	
}
