package com.java.basics.question2;

/**
 * 
 *Which two statements are true about Customer?
 * A) The Customer class cannot be extended.
 * B) The Customer class cannot be instantiated.
 * C) Subclasses of Customer cannot override getName() method.
 * D) Concrete subclasses of Customer must use a default constructor.
 * E) Concrete subclasses of Customer must implement the buy() method.
 * F) Subclasses of Customer must implement the buy() method. 
 *
 * Answer : B)
 */
public abstract class Customer {
	
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void buy();
}
