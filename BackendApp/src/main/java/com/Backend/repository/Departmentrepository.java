package com.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.model.Department;

@Repository
public interface Departmentrepository extends JpaRepository<Department, Long>{

}
