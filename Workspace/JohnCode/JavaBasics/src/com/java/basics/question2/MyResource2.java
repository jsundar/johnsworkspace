package com.java.basics.question2;

import java.io.Closeable;
import java.io.IOException;

public class MyResource2 implements Closeable {
	public void close() throws IOException {
		throw new IOException();
	}
}
