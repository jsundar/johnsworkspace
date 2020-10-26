package com.dp.creation.pattern.main;

import com.dp.creation.abstractfactory.AbstractShapeFactory;
import com.dp.creation.abstractfactory.FactoryProducer;
import com.dp.creation.abstractfactory.Shape;

public class AbstractFactoryMain {
	public static void main(String[] args) {
		
		AbstractShapeFactory roundedFactory = FactoryProducer.getShapeFactory(true);
		Shape  shapeSquare = roundedFactory.getShape("SQUARE");
		shapeSquare.draw();
		Shape  shapeRectangle = roundedFactory.getShape("RECTANGLE");
		shapeRectangle.draw();
		Shape  shapeCircle = roundedFactory.getShape("CIRCLE");
		shapeCircle.draw();
		
		AbstractShapeFactory factory = FactoryProducer.getShapeFactory(false);
		Shape square = factory.getShape("SQUARE");
		square.draw();
		Shape rectangle = factory.getShape("RECTANGLE");
		rectangle.draw();
		Shape circle = factory.getShape("CIRCLE");
		circle.draw();
		
	}
}
