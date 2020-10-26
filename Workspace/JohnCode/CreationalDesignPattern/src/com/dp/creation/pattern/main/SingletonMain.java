package com.dp.creation.pattern.main;

import com.dp.creation.singleton.SingletonObject;

public class SingletonMain {
	public static void main(String[] args) {
		SingletonObject object = SingletonObject.getInstance();
		object.getValue();
	}
}
