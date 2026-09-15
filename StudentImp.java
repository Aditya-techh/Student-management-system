package com.StudentManagementSystem.ServiceImp;

import java.util.List;


import org.springframework.stereotype.Service;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.repository.StudentRepository;
import com.StudentManagementSystem.service.StudentService;

@Service
public class StudentImp implements StudentService {

	final StudentRepository studentRepository;


	StudentImp(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	
	@Override
	public List<Student> getAllStudents() {
		
		List<Student> list= studentRepository.findAll();
		return list;
	}


	@Override
	public Student SaveStudent(Student student) {
		
		return studentRepository.save(student);
	}


	@Override
	public Student getStudentById(Integer id) {

	return	studentRepository.findById(id).get();
	
	}


	@Override
	public void deleteByid(Integer id) {

		studentRepository.deleteById(id);
	}


	
	
}
