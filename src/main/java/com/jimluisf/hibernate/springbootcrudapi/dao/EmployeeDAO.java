package com.jimluisf.hibernate.springbootcrudapi.dao;

import java.util.List;

import com.jimluisf.hibernate.springbootcrudapi.model.Employee;

public interface EmployeeDAO 
{
	List<Employee> get();
	Employee get(int id);
	void save(Employee employee);
	void delete(int id);
}
