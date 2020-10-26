package com.java.basics.question1;

public class Programmer extends Writer{

	public static void write() {
		System.out.println("Writing code");
	}
	
	public void writer() {
		System.out.println("Writting a code");
	}
	public static void main(String[] args) {
		Writer w = new Programmer();
		//Static method can not overridden
		w.write();
		//instance method can be overridden
		w.writer();
	}

}
