package com.example.spring4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring4.entity.Employee;
import com.example.spring4.projection.EmployeeProjection;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	List<EmployeeProjection> searchByTitleStartingWith(String start);
}