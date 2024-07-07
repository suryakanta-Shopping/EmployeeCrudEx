package com.nt.surya.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.nt.surya.entity.Employee;
import com.nt.surya.repository.EmployeeRepository;
import com.nt.surya.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	// HAS-A
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Integer saveEmployee(Employee employee) {
		employee = employeeRepository.save(employee);
		return employee.getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> findAll = employeeRepository.findAll();
		return findAll;
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	
	//Edit
	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> findById = employeeRepository.findById(id);

		if (findById.isPresent()) {
			Employee e = findById.get();
			return e;
		} // TODO : else throw Exception implement later

		return null;
	}

	//update
	@Override
	public void updateEmployee(Employee e) {
		employeeRepository.save(e);
		
	}
}
