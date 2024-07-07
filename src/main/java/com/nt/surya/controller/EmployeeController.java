package com.nt.surya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	/**
	 * Read id from Request URL
	 * call service for delete
	 * get latest data
	 * create success message
	 * send data to UI using Model
	 * return back to EmloyeeData.html
	 */
	
	@GetMapping("/delete")
	public String deleteEmployee(
			@RequestParam Integer id,
			Model model) 
	{
		//call service
		employeeServiceImpl.deleteEmployee(id);
		//one sucess message
		String message="Employe '"+id+"' Deleted";
		model.addAttribute("message", message);
		
		//get latest Data
		List<Employee> list = employeeServiceImpl.getAllEmployees();
		model.addAttribute("list", list);
		return "EmloyeeData";
	}

	/**
	 * show edit
	 * 
	 * read id from request param
	 * load DB row using findById
	 * send object to UI using Model
	 * use thymeleaf Form Reads data from object and fill it
	 * 
	 */
	
	@GetMapping("/edit")
	public String editEmployee(
			@RequestParam Integer id,
			Model model
			) {
		//load object from DB
		Employee editEmployee = employeeServiceImpl.getOneEmployee(id);
		//send object to UI
		model.addAttribute("employee", editEmployee );
		
		//retun to View Page
		return "EmployeeEdit";
	}
	
	/**
	 *  
	 *  do update
	 * Read Form data from edit page
	 * call Service
	 * redirect back to all
	 */
	
	@PostMapping("/update")
	public String updateEmployee(
			
			@ModelAttribute Employee employee,
			 Model model 
			) 
	
	
	{
		
		employeeServiceImpl.updateEmployee(employee);
		//req.getReqDis("/all")- in adv java
		return "redirect:all";  //it will redirect 'all' method page
	}
	
}
















