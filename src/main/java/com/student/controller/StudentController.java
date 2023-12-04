package com.student.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.context.Context;
import com.student.model.City;
import com.student.model.Student;

@Controller
public class StudentController extends HomeController{
	
	@GetMapping("/home")
	public String getHome(Model m) {
		System.out.println("Admin User => "+Context.USER_NAME);
		m.addAttribute("user", Context.USER_NAME);
		m.addAttribute("role", Context.Admin_USER.getRole());
		System.out.println("role => "+Context.Admin_USER.getRole());
		m.addAttribute("studentList", studentservice.studentList());
		
		return "home";
	}
	
	@GetMapping("/addstudent")
	public String addstudent(Model m) {
		Student student = new Student();
		m.addAttribute("student", student);
		m.addAttribute("city", cityService.cityList());
		m.addAttribute("TitleName", "Add Student");
		m.addAttribute("btn", "Add Student");
		return "addstudent";
	}
	
	@PostMapping("/addstudent")
	public String addstudent(Model m,@ModelAttribute("student") Student student) {
		String name = student.getName();
		String address = student.getAddress();
		int age = student.getAge();
		String dob = student.getDob();
		String phone = student.getPhone();
		String rollnumber = student.getRollnumber();
		
		City city  = student.getCity();
		
		if(name.isEmpty()) {
			m.addAttribute("route", "/addstudent");
			m.addAttribute("error", "Name is required.");
			m.addAttribute("student", student);
			m.addAttribute("city", cityService.cityList());
			m.addAttribute("TitleName", "Add Student");
			m.addAttribute("btn", "Add Student");
			return "addstudent";
		}
		if(address.isEmpty()) {
			m.addAttribute("student", student);
			m.addAttribute("route", "/addstudent");
			m.addAttribute("error", "Address is required.");
			m.addAttribute("city", cityService.cityList());
			m.addAttribute("TitleName", "Add Student");
			m.addAttribute("btn", "Add Student");
			return "addstudent";
		}
		if(city == null) {
			m.addAttribute("route", "/addstudent");
			m.addAttribute("error", "Please Select City.");
			m.addAttribute("student", student);
			m.addAttribute("city", cityService.cityList());
			m.addAttribute("TitleName", "Add Student");
			m.addAttribute("btn", "Add Student");
			return "addstudent";
		}
		if(age == 0) {
			m.addAttribute("student", student);
			m.addAttribute("route", "/addstudent");
			m.addAttribute("error", "Age is required.");
			m.addAttribute("city", cityService.cityList());
			m.addAttribute("TitleName", "Add Student");
			m.addAttribute("btn", "Add Student");
			return "addstudent";
		}
		if(dob.isEmpty()) {
			m.addAttribute("student", student);
			m.addAttribute("route", "/addstudent");
			m.addAttribute("error", "Date of Birth is required.");
			m.addAttribute("city", cityService.cityList());
			m.addAttribute("TitleName", "Add Student");
			m.addAttribute("btn", "Add Student");
			return "addstudent";
		}
		if(rollnumber.isEmpty()) {
			m.addAttribute("student", student);
			m.addAttribute("route", "/addstudent");
			m.addAttribute("error", "Rollnumber is required.");
			m.addAttribute("city", cityService.cityList());
			m.addAttribute("TitleName", "Add Student");
			m.addAttribute("btn", "Add Student");
			return "addstudent";
		}
		if(phone.isEmpty()) {
			m.addAttribute("student", student);
			m.addAttribute("route", "/addstudent");
			m.addAttribute("error", "Phone number is required.");
			m.addAttribute("city", cityService.cityList());
			m.addAttribute("TitleName", "Add Student");
			m.addAttribute("btn", "Add Student");
			return "addstudent";
		}
		
		Student findByRollnumber = studentservice.findByRollnumber(rollnumber);
		System.out.println("Roll Number => "+findByRollnumber);
		if(findByRollnumber != null) {
			m.addAttribute("student", student);
			m.addAttribute("route", "/addstudent");
			m.addAttribute("error", "Student Roll Number Already Exist.");
			m.addAttribute("city", cityService.cityList());
			m.addAttribute("TitleName", "Add Student");
			m.addAttribute("btn", "Add Student");
			return "addstudent";
		}
		else {
			student.setCreated(new Date());
			student.setModified(new Date());
			
			String addStudent = studentservice.addStudent(student);
			
			if(addStudent == "no") {
				m.addAttribute("student", student);
				m.addAttribute("route", "/addstudent");
				m.addAttribute("error", "Something Went Wrong.");
				m.addAttribute("city", cityService.cityList());
				m.addAttribute("TitleName", "Add Student");
				m.addAttribute("btn", "Add Student");
				return "addstudent";
			}
			else {
			m.addAttribute("student", student);
			m.addAttribute("route", "/addstudent");
			m.addAttribute("success", "Student added successfully...");
			m.addAttribute("city", cityService.cityList());
			m.addAttribute("TitleName", "Add Student");
			m.addAttribute("btn", "Add Student");
			m.addAttribute("disabled","disabled");
			return "addstudent";
			}
		}
		
	}

}
