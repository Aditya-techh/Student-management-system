package com.StudentManagementSystem.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.service.StudentService;

@Controller
public class StudentController {

	final StudentService service;

	StudentController(StudentService service) {
		this.service = service;
	}
	
	@GetMapping("/home")
	public String Home() {
		
		return "home";
	}
	
	
	@GetMapping("/Students")
	public String getAllStudents( Model model) {
		
	model.addAttribute("Students", service.getAllStudents());
		
	return "Students";
	}
	
	@GetMapping("Students/new")
	public String  CreateStudentForm(Model model) {
		
		Student student=new Student();
		
		model.addAttribute("student",student);
		
		return "Create-Student";
		
	}

	
	 @PostMapping("/students")
	    public String saveStudent(@ModelAttribute("student") Student student) {

	        service.SaveStudent(student);

	        return "redirect:/Students";
	    }
	 
	 
	 
	 @GetMapping("/students/edit/{id}")
	 public String editByid(@PathVariable Integer id,Model model) {
		 model.addAttribute("student", service.getStudentById(id));
		 
		 return "edit_student";
		 
		 
		
	}
	 
	 //Update Student or data coming
	 @PostMapping("/students/edit/{id}")
	public String UpdateStudent(@PathVariable Integer id,@ModelAttribute("student") Student student) {
		
		
	Student existingStudent=service.getStudentById(id);
	
	existingStudent.setFirstName(student.getFirstName());
	existingStudent.setLastName(student.getLastName());
	existingStudent.setEmail(student.getEmail());
	
	service.SaveStudent(existingStudent);
	
	return "redirect:/Students";
	}
	 
	 
	 
	 //Delete Student
	 @GetMapping("/students/{id}")
	 public String DeleteByid(@PathVariable Integer id) {
		 
		service.deleteByid(id);
		
		return "redirect:/Students";
		
	}
}
