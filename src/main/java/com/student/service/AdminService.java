package com.student.service;

import java.util.List;

import com.student.model.Admin;

public interface AdminService {
	
	public List<Admin> AdminList();
	
	public Admin findByUsername(String username);
	
	public Admin  findByUsernameAndPassword(String username, String password);
	
	public String saveAdmin(Admin admin);
	
	public Admin findById(int id);
	
	public String updateAdmin(int id , Admin admin);
	
	public String deleteAdmin(int id);

}
