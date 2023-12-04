package com.student.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.student.model.Admin;
import com.student.service.impl.AdminServiceImpl;

@Controller
public class RegistrationController{
	
	@Autowired
	AdminServiceImpl adminService;
	
	public  Admin findByUsername;

	@GetMapping("/register")
	public String register(Model m) {
		Admin admin = new Admin();
		m.addAttribute("admin", admin);
		m.addAttribute("route", "/register");

		return "register";
	}

	@PostMapping("/register")
	public String doregister(@ModelAttribute("admin") Admin admin, Model m) {
		String name = admin.getName();
		String username = admin.getUsername();
		String password = admin.getPassword();
		String role = admin.getRole();
		if (name.isEmpty()) {
			m.addAttribute("error", "Name is required.");
			return "register";
		}
		if (username.isEmpty()) {
			m.addAttribute("error", "Username is required.");
			m.addAttribute("name", name);
			return "register";
		}
		if (password.isEmpty()) {
			m.addAttribute("error", "Password is required.");
			m.addAttribute("name", name);
			m.addAttribute("username", username);

			return "register";
		}
		if (role.isEmpty()) {
			m.addAttribute("error", "Role is required.");
			m.addAttribute("name", name);
			m.addAttribute("username", username);
			m.addAttribute("password", password);

			return "register";
		}

		 Admin findUsername = adminService.findByUsername(username);

		if (findUsername != null) {
			m.addAttribute("error", "Username already taken.\n try again with new  username.");

			m.addAttribute("name", name);
			m.addAttribute("username", username);
			m.addAttribute("password", password);
			m.addAttribute("role", role);
			return "register";

		} else {
			admin.setCreated(new Date());
			admin.setModified(new Date());
			admin.setStatus(1);

			adminService.saveAdmin(admin);
			m.addAttribute("success", "User Created Successfully...");
			admin.setName("");
			admin.setUsername("");
			admin.setPassword("");
			m.addAttribute("admin", admin);
			return "register";
		}

	}

	@GetMapping("/forgotpass")
	public String forgotpass(Model m) {
		Admin admin = new Admin();
		m.addAttribute("admin", admin);
		m.addAttribute("route", "/forgotpass");
		return "forgot";
	}

	@PostMapping("/forgotpass")
	public String doforgotpass(@ModelAttribute("admin") Admin admin, Model m) {
		String username = admin.getUsername();
		if (username.isEmpty()) {
			m.addAttribute("error", "Username is required.");
			return "forgot";
		}
		 findByUsername = adminService.findByUsername(username);
		if(findByUsername == null) {
			m.addAttribute("error", "Username is not created yet. Please Signup.");
			return "forgot";
		}else {
			m.addAttribute("username", username);
			m.addAttribute("admin", admin);
			m.addAttribute("route", "/setpass");
			return "setpassword";
		}

	}
	
	@GetMapping("/setpassword")
	public String setpassword(Model m) {
		Admin admin = new Admin();
		m.addAttribute("admin", admin);
		m.addAttribute("route", "/setpass");
		return "setpassword";
	}
	
	@PostMapping("/setpass")
	public String dosetpassword(@ModelAttribute("admin")Admin admin, Model m) {
		
		String password = admin.getPassword();
		System.out.println("Password =>"+password);
		if(password.isEmpty()) {
			m.addAttribute("error", "Password is required.");
			m.addAttribute("username", admin.getUsername());
			return "forgot";
		}
		findByUsername.setPassword(password);
		System.out.println("Admin Id =>"+findByUsername.getId());
		String updateAdmin = adminService.updateAdmin(findByUsername.getId(), findByUsername);
		if(updateAdmin == "yes") {
			m.addAttribute("success", "Password Updated.");
			admin.setPassword("");
			m.addAttribute("admin", admin);
			return "setpassword";
		}
		else {
			m.addAttribute("error","Something Went Wrong.");
		return "setpassword";
		
		}
				
	}

}
