package com.hr.systems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.systems.entity.Employee;
import com.hr.systems.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee createEmployee(Employee Employee) {
		return employeeRepo.save(Employee);
	}

	public void deleteAllEmployees() {
		employeeRepo.deleteAll();
	}

	public void deleteEmployeeById(Long id) {
		employeeRepo.deleteById(id);
	}

	public void deleteEmployee(Employee Employee) {
		employeeRepo.delete(Employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepo.findById(id);
	}

}
