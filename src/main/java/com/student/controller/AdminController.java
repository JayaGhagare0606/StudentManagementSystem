package com.student.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.context.Context;
import com.student.model.Admin;

@Controller
public class AdminController extends HomeController {
	
	@GetMapping("/admin")
	public String getAdminList(Model m) {
		m.addAttribute("user", Context.USER_NAME);
		m.addAttribute("adminList", adminService.AdminList());
		adminService.AdminList().forEach((t)->{
			System.out.println(t);
		});
		return "admin";
	}
	
	@GetMapping("/adduser")
	public String adduser(Model m) {
		Admin admin = new Admin();
		m.addAttribute("admin", admin);
		m.addAttribute("TitleName", "User List");
		m.addAttribute("btn", "Add User");
		m.addAttribute("route", "/adduser");
		return "adduser";
	}
	
	@PostMapping("/adduser")
	public String adduser(@ModelAttribute("admin") Admin admin , Model m) {
		String name = admin.getName();
		String username = admin.getUsername();
		String password = admin.getPassword();
		
		if(name.isEmpty()) {
			m.addAttribute("admin", admin);
			m.addAttribute("TitleName", "User List");
			m.addAttribute("btn", "Add User");
			m.addAttribute("route", "/adduser");
			m.addAttribute("error", "Name is required.");
			return "adduser";
		}
		if(username.isEmpty()) {
			m.addAttribute("admin", admin);
			m.addAttribute("TitleName", "User List");
			m.addAttribute("btn", "Add User");
			m.addAttribute("route", "/adduser");
			m.addAttribute("error", "Username is required.");
			m.addAttribute("name", name);
			return "adduser";
		}
		Admin findByUsername = adminService.findByUsername(username);
		if(findByUsername != null) {
			m.addAttribute("admin", admin);
			m.addAttribute("TitleName", "User List");
			m.addAttribute("btn", "Add User");
			m.addAttribute("route", "/adduser");
			m.addAttribute("error", "Email Address Already Present.");
			return "adduser";
		}
		if(password.isEmpty()) {
			m.addAttribute("admin", admin);
			m.addAttribute("TitleName", "User List");
			m.addAttribute("btn", "Add User");
			m.addAttribute("route", "/adduser");
			m.addAttribute("error", "Password is required.");
			return "adduser";
		}
		else {
			admin.setModified(new Date());
			admin.setCreated(new Date());
			admin.setStatus(1);
			String saveAdmin = adminService.saveAdmin(admin);
			
			if(saveAdmin == "no") {
				m.addAttribute("admin", admin);
				m.addAttribute("TitleName", "User List");
				m.addAttribute("btn", "Add User");
				m.addAttribute("route", "/adduser");
				m.addAttribute("error", "Something Went Wrong.");
				return "adduser";
				}
			else {
				m.addAttribute("admin", admin);
				m.addAttribute("TitleName", "User List");
				m.addAttribute("btn", "Add User");
				m.addAttribute("route", "/adduser");
				m.addAttribute("success", "User Added Successfully.");
				return "adduser";
			}
		}	
	}
}