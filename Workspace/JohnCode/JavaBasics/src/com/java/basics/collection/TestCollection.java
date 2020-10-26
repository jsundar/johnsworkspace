package com.java.basics.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestCollection {
	
	private Set<Employee> set;
	private Set<Employee> treeSet;
	private List<Employee> list;
	private List<Employee> linkedList;
	private Map<String, Employee> map;
	private Map<String,Employee> treeMap;
	
	public TestCollection() {
		set = new HashSet<>();
		list = new ArrayList<>();
		map = new HashMap<>();
		treeSet = new TreeSet<>();
		linkedList = new LinkedList<>();
		treeMap = new TreeMap<>();
	}
	
	public Object[] getEmployees() {
		
		Object[] obj = new Object[10];
		
		obj[0] = new Employee("E001", "John", 5000);
		obj[1] = new Employee("E002", "Johnson", 6000);
		obj[2] = new Employee("E003", "Sundar", 5500);
		obj[3] = new Employee("E004", "Sundar", 5500);
		obj[4] = new Employee("E005", "Niro", 5000);
		obj[5] = new Employee("E006", "Patti", 6000);
		obj[6] = new Employee("E007", "thotti", 7500);
		obj[7] = new Employee("E008", "vitti", 8500);
		obj[8] = new Employee("E009", "satti", 5800);
		obj[9] = new Employee("E010", "chutti", 4500);
		
		return obj;
		
	}
	
	public void setHashSet(Object[] obj) {
		for(Object empp : obj) {
			set.add((Employee) empp);
		}
	}
	
	public void setTreeSet(Object[] obj) {
		for(Object empp : obj) {
			treeSet.add((Employee) empp);
		}
	}
	
	public void setArrayList(Object[] obj) {
		for(Object empp : obj) {
			list.add((Employee) empp);
		}
	}
	
	public void setLinkedList(Object[] obj) {
		for(Object empp : obj) {
			linkedList.add((Employee) empp);
		}
	}
	
	public void setHashMap(Object[] obj) {
		for(Object empp : obj) {
			Employee emp = (Employee) empp;
			map.put(emp.getEmpNo(), emp);
		}
	}
	
	public void setTreeMap(Object[] obj) {
		for(Object empp : obj) {
			Employee emp = (Employee) empp;
			treeMap.put(emp.getEmpNo(), emp);
		}
	}
	
	public Set<Employee> getSet() {
		return set;
	}
	
	public Set<Employee> getTreeSet() {
		return treeSet;
	}
	
	public List<Employee> getList() {
		return list;
	}
	
	public List<Employee> getLinkedList() {
		return linkedList;
	}
	
	public Map<String, Employee> getMap() {
		return map;
	}
	
	public Map<String, Employee> getTreeMap() {
		return treeMap;
	}
	
	public static void main(String[] args) {
		TestCollection test = new TestCollection();
		Object[] obj = test.getEmployees();
		
		test.setHashSet(obj);
		test.setTreeSet(obj);
		test.setArrayList(obj);
		test.setLinkedList(obj);
		test.setHashMap(obj);
		test.setTreeMap(obj);
		
		System.out.println("HASHSET");
		for(Employee emp : test.getSet()) {
			System.out.println(" Name : " + emp.getEmpName() + " : Emp No : " + emp.getEmpNo() + " : Salary : " + emp.getSalary());
		}
		
		System.out.println("TREESET");
		for(Employee emp : test.getTreeSet()) {
			System.out.println(" Name : " + emp.getEmpName() + " : Emp No : " + emp.getEmpNo() + " : Salary : " + emp.getSalary());
		}
	
		System.out.println("ARRAYLIST");
		for(Employee emp : test.getList()) {
			System.out.println(" Name : " + emp.getEmpName() + " : Emp No : " + emp.getEmpNo() + " : Salary : " + emp.getSalary());
		}
		
		System.out.println("LINKEDLIST");
		for(Employee emp : test.getLinkedList()) {
			System.out.println(" Name : " + emp.getEmpName() + " : Emp No : " + emp.getEmpNo() + " : Salary : " + emp.getSalary());
		}
		
		System.out.println("HASHMAP");
		for(Entry entry : test.getMap().entrySet()) {
			Employee emp = (Employee) entry.getValue();
			System.out.println(" Name : " + emp.getEmpName() + " : Emp No : " + emp.getEmpNo() + " : Salary : " + emp.getSalary());
		}
		
		System.out.println("TREEMAP");
		for(Entry entry : test.getMap().entrySet()) {
			Employee emp = (Employee) entry.getValue();
			System.out.println(" Name : " + emp.getEmpName() + " : Emp No : " + emp.getEmpNo() + " : Salary : " + emp.getSalary());
		}
	}

}
