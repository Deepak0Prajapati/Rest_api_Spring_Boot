package com.Backend.Service;

import java.util.List;


import com.Backend.model.Student;

public interface StudentService {
	
	List<Student> getStudents(int pageNumber,int pageSize);
	Student saveStudent(Student s);
	Student getSingleStudent(Long id);
	void DeleteStudent(Long id);
	Student updateStudent(Student s);
	List<Student> findByName(String name);
	List<Student> findByNameContaining(String keyword);
	List<Student> findByDepartmentName(String name);
	List<Student> getStudentByName(String name);

}
