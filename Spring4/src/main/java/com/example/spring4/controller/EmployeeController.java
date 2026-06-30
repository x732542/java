package com.example.spring4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring4.entity.Employee;
import com.example.spring4.projection.EmployeeProjection;
import com.example.spring4.repo.EmployeeRepo;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepo repo;
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> test1(@PathVariable Integer id){
		// SELECT * FROM Employee
		Employee e = repo.findById(id).orElse(null);
		return ResponseEntity.ok(e);
	}
	
	@GetMapping("/v2/{id}")
	public ResponseEntity<EmployeeProjection> test3(@PathVariable Integer id) {
		EmployeeProjection e = repo.searchByEmployeeid(id).orElse(null);
		if (e == null) {
			System.out.println("ERROR");
		}
		return ResponseEntity.ok(e);
	}
	
	@GetMapping("/title/{key}")
	public ResponseEntity<List<EmployeeProjection>> test2(@PathVariable String key){
		return ResponseEntity.ok(repo.searchByTitleStartingWith(key));
	}
	
	
}