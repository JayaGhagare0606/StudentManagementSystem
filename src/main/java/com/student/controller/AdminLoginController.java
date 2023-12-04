package com.student.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.context.Context;
import com.student.model.Admin;

@Controller
public class AdminLoginController extends HomeController{
		
	Admin adminUser = null;
	
	@GetMapping("/")
	public String AdminLogin(Model m) {
		
		Admin admin = new Admin();
		m.addAttribute("admin", admin);
		m.addAttribute("route", "/login");
		return "Login";
	}
	
	@PostMapping("/login")
	public String doLogin(@ModelAttribute Admin admin, Model m) {
		
		String username = admin.getUsername();
		String password = admin.getPassword();
		
		if(username.isEmpty()) {
			m.addAttribute("admin", admin);
			m.addAttribute("route", "/login");
			m.addAttribute("error", "Email is required");
			
			return "Login";
			
		}
		if(adminService.findByUsername(username) == null) {
			m.addAttribute("admin", admin);
			m.addAttribute("route", "/login");
			m.addAttribute("error", "Invalid Email. Please Enter Valid Email Address.");
			return "Login";
		}
		if(password.isEmpty()) {
			m.addAttribute("admin", admin);
			m.addAttribute("route", "/login");
			m.addAttribute("error", "Password is required");
			return "Login";
		}
		adminUser = adminService.findByUsernameAndPassword(username, password);
		if(adminService.findByUsernameAndPassword(username, password)== null) {
			m.addAttribute("admin", admin);
			m.addAttribute("route", "/login");
			m.addAttribute("error", "Invalid Password. Please Enter Valid Password.");
			return "Login";
		}
		else {
			m.addAttribute("admin", admin);
			m.addAttribute("user", adminUser.getName());
			m.addAttribute("role", adminUser.getRole());
			m.addAttribute("studentList", studentservice.studentList());
			Context.USER_NAME = adminUser.getName();
			Context.Admin_USER= adminUser;			
			return "redirect:/home";
		}
		
	}

}
