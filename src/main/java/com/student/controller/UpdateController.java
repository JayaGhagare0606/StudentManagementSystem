package com.student.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.model.City;
import com.student.model.Student;

@Controller
public class UpdateController extends HomeController{
	
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id")int id, Model m) {
		
		Student student = new Student();
		
		
		Student StudentById = studentservice.findStudentById(id);
		
		m.addAttribute("oneStudent", StudentById);
		m.addAttribute("student", student);
		m.addAttribute("TitleName", "Update Student");
		m.addAttribute("city", cityService.cityList());
		m.addAttribute("route", "/update/"+id);
		m.addAttribute("btn", "Update");
		return "update";
	}
	@GetMapping("/delete/{id}")
	public String deletestudent(@PathVariable("id")int id, Model m) {

		studentservice.deleteStudent(id);
		
		m.addAttribute("studentList", studentservice.studentList());
		
		return "home";
	}
	
	@PostMapping("/update/{id}")
	public String doUpdate(@PathVariable("id") int id, @ModelAttribute("student") Student student, Model m )
	{
		String name = student.getName();
		String address = student.getAddress();
		City city = student.getCity();
		int age = student.getAge();
		String dob = student.getDob();
		String phone = student.getPhone();
		String rollnumber = student.getRollnumber();
		if(name.isEmpty()) {
			m.addAttribute("student", student);
			m.addAttribute("TitleName", "Update Student");
			m.addAttribute("route", "/update/"+id);
			m.addAttribute("btn", "Update");
			m.addAttribute("error", "Name is required.");
			return "update";
		}
		if(address.isEmpty()) {
			m.addAttribute("student", student);
			m.addAttribute("TitleName", "Update Student");
			m.addAttribute("route", "/update/"+id);
			m.addAttribute("btn", "Update");
			m.addAttribute("error", "Address is required.");
			return "update";
		}
		if(city == null) {
			m.addAttribute("student", student);
			m.addAttribute("TitleName", "Update Student");
			m.addAttribute("city", cityService.cityList());
			m.addAttribute("route", "/update/"+id);
			m.addAttribute("btn", "Update");
			m.addAttribute("error", "City is required.");
			return "update";
		}
		if(age == 0) {
			m.addAttribute("student", student);
			m.addAttribute("TitleName", "Update Student");
			m.addAttribute("route", "/update/"+id);
			m.addAttribute("btn", "Update");
			m.addAttribute("error", "Age is required.");
			return "update";
		}
		if(dob.isEmpty()) {
			m.addAttribute("student", student);
			m.addAttribute("TitleName", "Update Student");
			m.addAttribute("route", "/update/"+id);
			m.addAttribute("btn", "Update");
			m.addAttribute("error", "Date of Birth is required.");
			return "update";
		}
		if(rollnumber.isEmpty()) {
			m.addAttribute("student", student);
			m.addAttribute("TitleName", "Update Student");
			m.addAttribute("route", "/update/"+id);
			m.addAttribute("btn", "Update");
			m.addAttribute("error", "RollNumber is required.");
			return "update";
		}
		if(phone.isEmpty()) {
			m.addAttribute("student", student);
			m.addAttribute("TitleName", "Update Student");
			m.addAttribute("route", "/update/"+id);
			m.addAttribute("btn", "Update");
			m.addAttribute("error", "Phone Number is required.");
			return "update";
		}else {
			
			student.setCreated(new Date());
			student.setModified(new Date());
			
			String updateStudent = studentservice.updateStudent(id, student);
			
			if(updateStudent == "no") {
				m.addAttribute("student", student);
				m.addAttribute("TitleName", "Update Student");
				m.addAttribute("route", "/update/"+id);
				m.addAttribute("btn", "Update");
				m.addAttribute("error", "Something Went Wrong.");
				return "update";
			}
			else {
				m.addAttribute("student", student);
				m.addAttribute("TitleName", "Update Student");
				m.addAttribute("route", "/update/"+id);
				m.addAttribute("btn", "Update");
				m.addAttribute("success", "Student Updated successfully...");
				return "update";
			
			}
		}
		
	}
		
}
