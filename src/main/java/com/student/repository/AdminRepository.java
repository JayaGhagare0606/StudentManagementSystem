package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public Admin findByUsername(String username);
	
	public Admin  findByUsernameAndPassword(String username, String password);

}
