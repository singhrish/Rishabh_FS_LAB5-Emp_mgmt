package com.GL.Emp.EmployeeManagement.service;

import java.util.List;

import com.GL.Emp.EmployeeManagement.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees() ;

	public Employee getEmployee(int id) ;
	
	public Employee updatEmployee(Employee employee) ;
	
	public Employee saveEmployee(Employee employee) ;
	
	public void deleteEmployee(int id) ;
	
}
