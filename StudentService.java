package com.StudentManagementSystem.service;

import java.util.List;

import com.StudentManagementSystem.entity.Student;

public interface StudentService {

	
	public List<Student> getAllStudents() ;
	public Student SaveStudent(Student student);
	
	public Student getStudentById(Integer id); 
		
	
	
	public void deleteByid(Integer id);
	
		
	
	
}
