package com.java.basics.collection;

public class Employee implements Comparable<Employee> {
	
	private static final long serialVersionUID = 1L;
	
	private String empNo;
	private String empName;
	private int salary;
	
	public Employee(String empNo, String empName, int salary) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
	}
	
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o1) {
		return this.salary - o1.salary;
	}
	
}
