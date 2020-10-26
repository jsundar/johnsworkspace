package com.java.basics.question2;

import java.io.IOException;

public class MyResource1 implements AutoCloseable {
	public void close() throws IOException {
		System.out.print("1 ");
	}
}
