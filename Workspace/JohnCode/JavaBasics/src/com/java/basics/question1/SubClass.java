package com.java.basics.question1;

public class SubClass extends SuperClass{

	//Can not override the super class constructor
	//int a;
	//SubClass(int a) {
	//	this.a =a;
	//}
	
	SubClass() {
		//this(10);
		//SuperClass(10);
		//super.SuperClass (10);
		super(10);
		System.out.println("Sub 2");
	}

}
