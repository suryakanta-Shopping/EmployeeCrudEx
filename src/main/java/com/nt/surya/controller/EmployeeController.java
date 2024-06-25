package com.nt.surya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.surya.service.impl.EmployeeServiceImpl;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//HAS-A
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	
	@GetMapping("/register")
	public String showRegisterPage() {
		return "RegisterPage";
	}
}
