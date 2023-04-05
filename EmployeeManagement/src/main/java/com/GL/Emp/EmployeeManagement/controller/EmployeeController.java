package com.GL.Emp.EmployeeManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GL.Emp.EmployeeManagement.service.EmployeeService;
import com.GL.Emp.EmployeeManagement.model.Employee;


@Controller
@RequestMapping("employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String showEmpList()
	{
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {

		// create employee object to hold employee form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";

	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String editemployeeForm(@PathVariable int id, Model model) {
		model.addAttribute("employee", employeeService.getEmployee(id));
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateemployee(@PathVariable int id, @ModelAttribute("employee") Employee employee, Model model) {

		// get employee from database by id

		Employee existingEmployee = employeeService.getEmployee(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());

		// save updated employee object
		employeeService.updatEmployee(existingEmployee);

		return "redirect:/employees";
	}

	// handler method to handle delete employee request

	@GetMapping("/employees/{id}")
	public String deleteemployee(@PathVariable int id) {
		 employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}
}
