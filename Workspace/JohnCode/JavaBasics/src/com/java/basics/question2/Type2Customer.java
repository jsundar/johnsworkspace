package com.java.basics.question2;

public class Type2Customer extends Customer {

	public Type2Customer(String name) {
		super(name);
	}

	public void buy() {
		System.out.println(getName() + " Bought Sea Food");
	}
}
