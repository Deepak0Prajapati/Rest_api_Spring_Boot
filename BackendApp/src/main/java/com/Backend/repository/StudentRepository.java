package com.Backend.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Backend.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	List<Student> findByName(String name);
	List<Student> findByNameContaining(String keyword, Sort sort);
	List<Student> findByDepartmentName(String name);
	
	@Query("FROM Student WHERE department.name = :name")
	List<Student> getStudentByDepartmetnName(String name);

}
