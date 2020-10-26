package com.java.basics.question1;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		TestMain obj = new TestMain();
		// obj.testArrayList();
		// obj.testArrayList2();
		// obj.testException();
		obj.testString();
	}

	/**
	 * What is the result? A) null B) 10 C) 0 D) An IndexOutOfBoundsException is
	 * thrown at runtime Anser : D) An IndexOutOfBoundsException is thrown at
	 * runtime
	 */
	public void testArrayList() {
		List<Integer> elements = new ArrayList<>();
		elements.add(10);
		int firstElmnt = elements.get(1);
		System.out.println(firstElmnt);
	}

	/**
	 * Which two code fragments can be inserted at Line n1, independently, enable to
	 * print Stand? int cardVal = 6; int cardVal = 10; int cardVal = 14; int cardVal
	 * = 18; Answer : card value 14, 18
	 */
	public void testSwitch() {
		int cardVal = 6;
		// int cardVal = 10;
		// int cardVal = 14;
		// int cardVal = 18;
		switch (cardVal) {
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
			System.out.println("Hit");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("Double");
			break;
		case 15:
		case 16:
			System.out.println("Surrender");
			break;
		default:
			System.out.println("Stand");
		}
	}

	/**
	 * What is the result? A) Pen Pencil Box B) Pen Pencil C) Box D) Compilation
	 * fails.
	 * 
	 * Answer : Box
	 */
	public void testArrayList2() {
		List<String> items = new ArrayList<>();
		items.add("Pen");
		items.add("Pencil");
		items.add("Box");
		for (String i : items) {
			if (i.indexOf("P") == 0) { // if fiirst index is matched with P then return 0, if it is not found then -1
				continue;
			} else {
				System.out.print(i + " ");
			}
		}
	}

	/**
	 * What is the result? A) E1 B) E2 C) 5 10 E1 D) Compilation fails.
	 * 
	 * Concept is : Catch Exception at the end of all other exception otherwise it
	 * will be compilation error
	 * 
	 */

	public void testException() {
		int x = 10;
		int y = 2;
		try {
			for (int z = 2; z >= 0; z--) {
				int ans = x / z;
				System.out.print(ans + " ");
			}
		} catch (ArithmeticException e1) {
			System.out.println("E2");
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("E1");
		}

	}

	/**
	 * A) -1 B) 3 C) 4 D) A StringIndexOutOfBoundsException is thrown at runtime.
	 */
	public void testString() {
		StringBuilder s1 = new StringBuilder("Java");
		String s2 = "Love";
		s1.append(s2);
		s1.substring(4);
		int foundAt = s1.indexOf(s2);
		System.out.println(foundAt);
	}
}
