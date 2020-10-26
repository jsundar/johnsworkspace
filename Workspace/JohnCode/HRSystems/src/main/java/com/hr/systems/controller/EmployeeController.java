package com.hr.systems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.systems.entity.Employee;
import com.hr.systems.repo.EmployeeRepo;
import com.hr.systems.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping()
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		
		Employee employeeObj = empService.createEmployee(employee);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(employeeObj, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@PutMapping()
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		empService.createEmployee(employee);
		return responseEntity;
	}
	
	@DeleteMapping()
	public ResponseEntity<Employee> deleteAllEmployee() {
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		empService.deleteAllEmployees();
		return responseEntity;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteAllEmployee(@PathVariable Long id) {
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		empService.deleteEmployeeById(id);
		return responseEntity;
	}
	
	@GetMapping()
	public ResponseEntity<List<Employee>> findAllEmployee() {
		ResponseEntity<List<Employee>> responseEntity = null;
		List<Employee> employeeList = empService.getAllEmployees();
		 responseEntity = new ResponseEntity<>(employeeList, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findAllEmployee(@PathVariable Long id) {
		ResponseEntity<Employee> responseEntity = null;
		Employee employee = empService.getEmployeeById(id).get();
		 responseEntity = new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
		return responseEntity;
	}	
}
