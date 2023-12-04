package com.student.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.student.model.Admin;
import com.student.service.AdminService;

@Service
public class AdminServiceImpl extends HomeService implements AdminService{

	@Override
	public List<Admin> AdminList() {
		// TODO Auto-generated method stub
		return adminRepo.findAll(Sort.by(Sort.Direction.ASC , "name"));
	}

	@Override
	public String saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin save = adminRepo.save(admin);
		if(save == null) {
			return "no";}
		return "yes";
	}

	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		List<Admin> adminList = AdminList();
		Admin a = null;
		for(Admin t : adminList) {
			if( t.getId() == id) {
				a = t;
			}
		}
		return a;
	}

	@Override
	public String updateAdmin(int id, Admin admin) {
		// TODO Auto-generated method stub
		Admin oldAdmin = findById(id);
		
		
		oldAdmin.setName(admin.getName());
		oldAdmin.setUsername(admin.getUsername());
		oldAdmin.setPassword(admin.getPassword());
		oldAdmin.setRole(admin.getRole());
		oldAdmin.setStatus(admin.getStatus());
		oldAdmin.setModified(new Date());
		
		Admin save = adminRepo.save(oldAdmin);
		
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public String deleteAdmin(int id) {
		// TODO Auto-generated method stub
		Admin admin = findById(id);
		adminRepo.delete(admin);
		
		return "done";
	}

	@Override
	public Admin findByUsername(String username) {
		// TODO Auto-generated method stub
		return adminRepo.findByUsername(username);
	}

	@Override
	public Admin findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return adminRepo.findByUsernameAndPassword(username, password);
	}
	
	
}