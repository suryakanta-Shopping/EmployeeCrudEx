package com.nt.surya.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.surya.entity.Employee;
import com.nt.surya.repository.EmployeeRepository;
import com.nt.surya.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	
	//HAS-A
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Integer saveEmployee(Employee employee) {
		employee=employeeRepository.save(employee);
		return employee.getId();
	}
}
