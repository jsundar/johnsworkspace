package com.java.basics.question2;

import java.util.ArrayList;
import java.util.List;

public class Toy {
	double price;
	String color;

	Toy(String color, double price) {
		this.color = color;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}
	
	/**
	 * Which code fragment can be inserted at Line n1 to enable the code to print Total Price of Red Toys: 20.0?
		A) .flatMap(e -> e.getPrice())
		B) .mapToDouble(e -> e.getPrice())
		C) .map(e -> e.getPrice())
		D) .peek(e -> e.getPrice()) 
	 */
	public static void main(String[] args) {
		List<Toy> toys = new ArrayList<>();
		toys.add(new Toy("red", 10));
		toys.add(new Toy("yellow", 10));
		toys.add(new Toy("red", 10));
		double totalPrice = toys.stream()
		.filter(e -> e.getColor() == "red")
		.mapToDouble(e -> e.getPrice())
		.sum();
		System.out.println("Total Price of Red Toys: " + totalPrice);
	}
	
}
