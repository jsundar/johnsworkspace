package com.java.basics.question2;

public class Type1Customer extends Customer {

	public Type1Customer(String name) {
		super(name);
	}

	public void buy() {
		System.out.println(getName() + " Bought Vegetables");
	}
}
