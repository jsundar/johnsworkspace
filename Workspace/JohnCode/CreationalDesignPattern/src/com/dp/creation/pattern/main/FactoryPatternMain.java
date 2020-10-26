package com.dp.creation.pattern.main;

import com.dp.creation.factory.Shape;
import com.dp.creation.factory.ShapeFactory;

public class FactoryPatternMain {
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		Shape square = factory.getShape("SQUARE");
		square.draw();
		Shape rectangle = factory.getShape("RECTANGLE");
		rectangle.draw();
		Shape circle = factory.getShape("CIRCLE");
		circle.draw();
	}

}
