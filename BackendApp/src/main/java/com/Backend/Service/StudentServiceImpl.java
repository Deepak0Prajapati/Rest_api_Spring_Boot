package com.Backend.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.Backend.model.Student;
import com.Backend.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	
	
	@Override
	public List<Student> getStudents(int pageNumber,int pagSize) {
		Pageable pages=PageRequest.of(pageNumber, pagSize, Direction.DESC,"id");
		return repository.findAll(pages).getContent();
	}


	@Override
	public Student saveStudent(Student s) {
		Student Studnet = repository.save(s);
		return Studnet;
	}


	@Override
	public Student getSingleStudent(Long id) {
		Optional<Student> student = repository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}
		throw new RuntimeException("Student not found with id :"+id);
	}


	@Override
	public void DeleteStudent(Long id) {
		 repository.deleteById(id);
	}


	@Override
	public Student updateStudent(Student s) {
		Student student = repository.save(s);
		return student;
	}


	@Override
	public List<Student> findByName(String name) {
		return 	repository.findByName(name);

	}


	@Override
	public List<Student> findByNameContaining(String keyword) {
		
		Sort sort=Sort.by(Sort.Direction.DESC,"id");
		
		return repository.findByNameContaining(keyword,sort);
	}


	@Override
	public List<Student> findByDepartmentName(String name) {
		
		return repository.findByDepartmentName(name);
	}


	@Override
	public List<Student> getStudentByName(String name) {
		
		return repository.getStudentByDepartmetnName(name);
	}


}
