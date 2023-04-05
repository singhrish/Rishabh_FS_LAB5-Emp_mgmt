package com.GL.Emp.EmployeeManagement.service;

import java.util.List;

import com.GL.Emp.EmployeeManagement.dao.EmployeeDao;
import com.GL.Emp.EmployeeManagement.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao employeedao ;

	public EmployeeServiceImpl(EmployeeDao employeedao)
	{
		super();
		this.employeedao = employeedao ;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeedao.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeedao.findById(id).get();
	}

	@Override
	public Employee updatEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeedao.save(employee);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeedao.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeedao.deleteById(id);
	}

}
