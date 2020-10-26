package com.dp.creation.singleton;

public class SingletonObject {
	
	private static SingletonObject OBJECT = new SingletonObject();
	
	private SingletonObject() {}
	
	public static SingletonObject getInstance() {
		if(OBJECT == null) {
			OBJECT = new SingletonObject();
		}
		return OBJECT;
	}
	
	public void getValue() {
		System.out.println("SINGLETON OBJECT");
	}

}
