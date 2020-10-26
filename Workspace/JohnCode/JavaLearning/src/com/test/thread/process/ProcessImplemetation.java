package com.test.thread.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.test.thread.bean.Employee;

public class ProcessImplemetation implements Runnable {
	
	static File file;
	static {
		file = new File("D://STUDY//result.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private List<Employee> employeeList = new ArrayList<>();
	
	public void addEmployee(Employee emp) {
		employeeList.add(emp);
	}
	
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public void displayEmployeeList(Employee emp) {
		System.out.println("empNo : " + emp.getEmpNo() + " empName : " + emp.getEmpName() + " empSalary : " + emp.getSalary() + " Gender : " + emp.getGender());
	}

	@Override
	public void run() {
		writeFile(employeeList);
	}
	
	public synchronized void writeFile(List<Employee> empList) {
		FileWriter writer;
		try {
			writer = new FileWriter(file, true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			 bufferedWriter.newLine();
	        for(Employee emp : empList) {
	        	 bufferedWriter.write("empNo : " + emp.getEmpNo() + " empName : " + emp.getEmpName() + " empSalary : " + emp.getSalary() + " Gender : " + emp.getGender());
	             bufferedWriter.newLine();
	        }

	        bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}
