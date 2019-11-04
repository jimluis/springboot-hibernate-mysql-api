package com.jimluisf.hibernate.springbootcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jimluisf.hibernate.springbootcrudapi.model.Employee;
import com.jimluisf.hibernate.springbootcrudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController 
{

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public List<Employee> get()
	{
		return empService.get();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		Employee employeeobj = empService.get(id);

		if(employeeobj == null)
			throw new RuntimeException("Employee with id "+id+" was not found");
		
		return employeeobj;
	}
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employee)
	{
		empService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable int id)
	{
		empService.delete(id);
		return "Employee has been deleted with id: "+id;
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employee)
	{
		empService.save(employee);
		return employee;
	}
	
}
