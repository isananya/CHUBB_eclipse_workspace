package com.chubb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.chubb.model.Student;
import com.chubb.repository.StudentRepository;

@RestController
public class MainController {
	
	@Autowired
	StudentRepository studentRepo;
	
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student student) {
		studentRepo.save(student);
	}
	
	@GetMapping("/fetchStudents")
	public List<Student> fetchStudents(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/getStudent/{id}")
	public Student fetchStudentById(@PathVariable Integer id){
		return studentRepo.findById(id).orElse(null);
	}
	
	@PutMapping("/updateStudent")
	public void updateStudent(@RequestBody Student student) {
		Student data = studentRepo.findById(student.getRno()).orElse(null);
		if(data!=null) {
			data.setName(student.getName());
			data.setAddress(student.getAddress());
			studentRepo.save(data);
		}
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable Integer id){
		studentRepo.deleteById(id);
	}
}
