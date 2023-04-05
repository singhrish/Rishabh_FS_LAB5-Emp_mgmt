package com.GL.Emp.EmployeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GL.Emp.EmployeeManagement.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
