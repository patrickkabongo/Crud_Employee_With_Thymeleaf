package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// That's it ... no need to write any code LOL!
	
	// add a method to sort by first name
	
	public List<Employee> findAllByOrderByFirstNameAsc();
}
