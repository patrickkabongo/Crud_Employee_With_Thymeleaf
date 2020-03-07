package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {	
	
	private EmployeeService employeeService;
	
		
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}


	@GetMapping("/list")
	public String getEmployees(Model theModel) {
		
		List<Employee> theEmployees;
		
		theEmployees = employeeService.findAll();
		
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create a model attribute to bind form data
		
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		// save the employee using our service
		employeeService.save(theEmployee);
		
		return "redirect:/employees/list";
	}
}
