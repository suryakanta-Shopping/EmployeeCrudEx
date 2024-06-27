package com.nt.surya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.surya.entity.Employee;
import com.nt.surya.service.impl.EmployeeServiceImpl;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	// HAS-A
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	/**
	 * If End user enter /register in addressbar this method is called and loads
	 * EmployeeRegister.html from /template folder
	 * 
	 * @return
	 */

	@GetMapping("/register")
	public String showRegisterPage() {
		return "RegisterPage";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee, Model model) {

		Integer id = employeeServiceImpl.saveEmployee(employee);
		String message = "Employee   '" + id + "'  Created";
		model.addAttribute("message", message);
		return "RegisterPage";
	}

	/**
	 * Fetch data from DB using service send data to UI using Model Return to
	 * EmployeeData.html
	 * 
	 * @return
	 */

	@GetMapping("/all")
	public String viewAllEmployees(Model model) {
		List<Employee> emplist = employeeServiceImpl.getAllEmployees();
		model.addAttribute("emplist", emplist);
		return "EmployeeData";
	}

}
