package com.test.thread.bean;

public class Employee {
	
	String empNo;
	String empName;
	String salary;
	String gender;
	
	public Employee() {}

	public Employee(String empNo, String empName, String salary, String gender) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
		this.gender = gender;
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public boolean equals(Employee emp) {
        if (this == emp) {
            return true;
        }
        if (emp != null && emp.empNo == this.empNo) {
            return true;
        }
        return false;
    }
    
	public int hashCode() {
		  int result = 17;
	      result = 31 * result + empNo.hashCode();
	      return result;
    }

}
