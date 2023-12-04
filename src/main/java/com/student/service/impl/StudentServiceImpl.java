package com.student.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl extends HomeService implements StudentService {

	@Override
	public List<Student> studentList() {
		// TODO Auto-generated method stub
		return studentRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	@Override
	public String addStudent(Student student) {
		// TODO Auto-generated method stub
		Student save = studentRepo.save(student);
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public Student findStudentById(int id) {
		List<Student> studentList = studentList();
		Student s = null;
		for(Student x : studentList) {
			if(x.getId() == id) {
			s = x;
		}
			
		}
		return s;
	}

	@Override
	public String updateStudent(int id, Student student) {
		// TODO Auto-generated method stub
		Student oldStudent = findStudentById(id);
		
		oldStudent.setModified(new Date());
		oldStudent.setName(student.getName());
		oldStudent.setPhone(student.getPhone());
		oldStudent.setAge(student.getAge());
		oldStudent.setAddress(student.getAddress());
		oldStudent.setCity(student.getCity());
		oldStudent.setDob(student.getDob());
		oldStudent.setRollnumber(student.getRollnumber());
		oldStudent.setModified(new Date());
		oldStudent.setStatus(student.getStatus());
		
		Student save = studentRepo.save(oldStudent);
		
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public String deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student student = findStudentById(id);
		studentRepo.delete(student);
		return "done";
	}

	@Override
	public Student findByDob(String dob) {
		// TODO Auto-generated method stub
		return studentRepo.findByDob(dob);
	}

	@Override
	public Student findByPhone(String phone) {
		// TODO Auto-generated method stub
		return studentRepo.findByPhone(phone);
	}

	@Override
	public Student findByRollnumber(String rollnmber) {
		// TODO Auto-generated method stub
		return studentRepo.findByRollnumber(rollnmber);
	}

	@Override
	public List<Student> studentname(String name) {
		// TODO Auto-generated method stub
		
		return studentRepo.findByName(name);
	}

	
}
