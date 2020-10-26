package com.hr.systems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.systems.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
