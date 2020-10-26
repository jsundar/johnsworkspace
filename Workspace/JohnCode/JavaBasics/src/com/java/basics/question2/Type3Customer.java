package com.java.basics.question2;

public class Type3Customer extends Customer {

	public Type3Customer(String name) {
		super(name);
	}
	
	public void buy() {
		System.out.println(getName() + " Bought Meat ");
	}
	
	public static void main(String[] args) {
		Customer a = new Type3Customer("John");
		a.buy();
		Customer b = new Type2Customer("Sundar");
		b.buy();
		Customer c = new Type1Customer("Niro");
		c.buy();
		
		Type1Customer t1 = new Type1Customer("Type 1");
		Type2Customer t2 = new Type2Customer("Type 2");
		Type2Customer t3 = new Type2Customer("Type 3");
		
		t1.buy();
		t2.buy();
		t3.buy();
	}

}

