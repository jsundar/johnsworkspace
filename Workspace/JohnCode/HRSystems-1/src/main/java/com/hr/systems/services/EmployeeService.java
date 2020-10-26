package com.hr.systems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.systems.domain.Employee;
import com.hr.systems.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public String getDisplayMsg() {
		return "Hello World Service";
	}

	public List<Employee> getEmployees() {
		return employeeRepo.findAll();
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public List<Employee> createEmployees(List<Employee> employees) {
		return employeeRepo.saveAll(employees);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
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

	public Employee getEmployeeById(Long id) {
		return employeeRepo.findById(id).get();
	}

}
