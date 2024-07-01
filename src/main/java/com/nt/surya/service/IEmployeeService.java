package com.nt.surya.service;

import java.util.List;

import com.nt.surya.entity.Employee;

public interface IEmployeeService {

	Integer saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	void deleteEmployee(Integer id);

	Employee getOneEmployee(Integer id);
}
