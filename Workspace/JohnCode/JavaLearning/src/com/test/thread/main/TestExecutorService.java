package com.test.thread.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.test.thread.bean.Employee;
import com.test.thread.process.ProcessImplemetation;

public class TestHasCodeOverridden {
	
	private List<Employee> employeeList;
	ProcessImplemetation object;
	
	public static void main(String[] args) {
		
		List<Employee> empList = addEmployees();
		List<Employee> list1 = empList.subList(0, 999);
		List<Employee> list2 = empList.subList(1000, 1999);
		List<Employee> list3 = empList.subList(2000, 2999);
		List<Employee> list4 = empList.subList(3000, 3999);
		List<Employee> list5 = empList.subList(4000, 4999);
		
		List<Object> threadList = new ArrayList<>();
		threadList.add(list1);
		threadList.add(list2);
		threadList.add(list3);
		threadList.add(list4);
		threadList.add(list5);
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		List<Runnable> list = partitionList(threadList);
		for(Runnable run : list) {
			service.execute(run);
		}
		service.shutdownNow();
	}
	
	@SuppressWarnings("unchecked")
	private static List<Runnable> partitionList(List<Object> partitionList) {
		List<Runnable> prcoessList = new ArrayList<>();
		for(Object obj : partitionList) {
			ProcessImplemetation impl = new ProcessImplemetation();
			impl.setEmployeeList((List<Employee>)obj);
			prcoessList.add(impl);
		}
		return prcoessList;
	}
	
	private static List<Employee> addEmployees() {
		String empNo = "ABC";
		String empName = "Test";
		String salary = "5000";
		String gender = "Male";
		ArrayList<Employee> empList = new ArrayList<>();
		for(int i=1; i <= 5000; i++) {
			empList.add(new Employee(empNo+i, empName+i ,salary+i, gender));
		}
		return empList;
	}

	
}
