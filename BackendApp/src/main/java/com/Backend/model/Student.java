package com.Backend.model;


import com.Backend.Request.StudentRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@NotBlank(message = "Name should not be null!")
	private   String name;
	
	@JoinColumn(name = "department_id")
	@OneToOne
	private Department department;
	
	
	
	
	
	
	public Student(long id, @NotBlank(message = "Name should not be null!") String name, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}



	public Student(StudentRequest req) {
		this.name=req.getName();
		
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}




	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", department=" + department + "]";
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
}
