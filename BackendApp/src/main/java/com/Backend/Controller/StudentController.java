package com.Backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Request.StudentRequest;
import com.Backend.Service.StudentService;
import com.Backend.model.Department;
import com.Backend.model.Student;
import com.Backend.repository.Departmentrepository;
import com.Backend.repository.StudentRepository;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private Departmentrepository departmentrepository;
	
	@PostMapping("/students")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody StudentRequest srequest) {
		Department dept=new Department();
		dept.setName(srequest.getDepartment());
		dept = departmentrepository.save(dept);
		
		Student student=new Student(srequest);
		student.setDepartment(dept);
		repository.save(student);
		
		
		
		return new ResponseEntity<Student>(student,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(@RequestParam int pageNumber,int pageSize) {
		
		return new ResponseEntity<List<Student>>(service.getStudents(pageNumber,pageSize),HttpStatus.OK);
	}
	
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student s) {
		s.setId(id);
		Student updateStudent = service.updateStudent(s);
		return new ResponseEntity<Student>(updateStudent,HttpStatus.OK);
		
			
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		return new ResponseEntity<Student>(service.getSingleStudent(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id) {
		service.DeleteStudent(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/students/name")
	public ResponseEntity<List<Student>> getStudentByName(@RequestParam String name){
		List<Student> student = service.findByName(name);
		return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/students/containing/{keyword}")
	public ResponseEntity<List<Student>> getStudentByNameContaining(@PathVariable String keyword){
		List<Student> student = service.findByNameContaining(keyword);
		return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
		
	}
	
	@GetMapping("/student/dept/{dept}")
	public ResponseEntity<List<Student>> getStudentByDepartment(@PathVariable String dept){
		List<Student> student = service.findByDepartmentName(dept);
		return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
	}
	
	@GetMapping("/student/department/{dept}")
	public ResponseEntity<List<Student>> getstudentBydept(@PathVariable String dept){
		List<Student> student = service.findByDepartmentName(dept);
		return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
	}
 	
	


}
