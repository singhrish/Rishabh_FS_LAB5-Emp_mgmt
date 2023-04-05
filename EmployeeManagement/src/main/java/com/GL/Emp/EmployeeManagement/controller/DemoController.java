package com.GL.Emp.EmployeeManagement.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/home")
	public String showHome(Model model)
	{
		model.addAttribute("thedate", new Date()) ;
		return "home";
	}
}
