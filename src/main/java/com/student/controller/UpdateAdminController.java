package com.student.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.model.Admin;

@Controller
public class UpdateAdminController extends HomeController {
	
	@GetMapping("/updateadmin/{id}")
	public String updateadmin(@PathVariable("id")int id, Model m) {
		Admin admin = new Admin();
		Admin findById = adminService.findById(id);
		m.addAttribute("oneAdmin", findById);
		m.addAttribute("route", "/updateadmin/"+id);
		m.addAttribute("admin", admin);
		m.addAttribute("TitleName", "Update Admin");
		m.addAttribute("btn", "Update");
		return "updateadmin";
	}
	@PostMapping("/updateadmin/{id}")
	public String updateadmin(@PathVariable("id")int id, @ModelAttribute("admin")Admin admin, Model m) {
		String name = admin.getName();
		String username = admin.getUsername();
		String password = admin.getPassword();
		
		if(name.isEmpty()) {
			m.addAttribute("route", "/updateadmin/"+id);
			m.addAttribute("admin", admin);
			m.addAttribute("TitleName", "Update Admin");
			m.addAttribute("btn", "Update");
			m.addAttribute("error", "Name is required.");
			return "updateadmin";
		}
		if(username.isEmpty()) {
			m.addAttribute("route", "/updateadmin/"+id);
			m.addAttribute("admin", admin);
			m.addAttribute("TitleName", "Update Admin");
			m.addAttribute("btn", "Update");
			m.addAttribute("error", "UserName is required.");
			return "updateadmin";
		}
		if(password.isEmpty()) {
			m.addAttribute("route", "/updateadmin/"+id);
			m.addAttribute("admin", admin);
			m.addAttribute("TitleName", "Update Admin");
			m.addAttribute("btn", "Update");
			m.addAttribute("error", "Password is required.");
			return "updateadmin";
		}
		else {
			admin.setCreated(new Date());
			admin.setModified(new Date());
			
			String updateAdmin = adminService.updateAdmin(id, admin);
			if(updateAdmin == "no") {
				m.addAttribute("route", "/updateadmin/"+id);
				m.addAttribute("admin", admin);
				m.addAttribute("TitleName", "Update Admin");
				m.addAttribute("btn", "Update");
				m.addAttribute("error", "Something Went Wrong.");
				return "updateadmin";
			}
			else {
				m.addAttribute("route", "/updateadmin/"+id);
				m.addAttribute("admin", admin);
				m.addAttribute("TitleName", "Update Admin");
				m.addAttribute("btn", "Update");
				m.addAttribute("success", "Admin Updated Successfully..");
				return "updateadmin";
			}
		}
	}
	
	@GetMapping("/deleteadmin/{id}")
	public String deleteadmin(@PathVariable("id")int id, Model m) {
		adminService.deleteAdmin(id);
		m.addAttribute("adminList", adminService.AdminList());
		return "redirect:/admin";
	}

}
