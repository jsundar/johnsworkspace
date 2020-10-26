package com.dp.creation.factory;

public class ShapeFactory {
	
	public Shape getShape(String shape) {
		
		if(shape == null) {
			return null;
		} else if(shape.equals("CIRCLE")) {
			return new Circle();
		} else if(shape.equals("SQUARE")) {
			return new Square();
		} else if(shape.equals("RECTANGLE")) {
			return new Rectangle();
		} else {
			return null;
		}
	}

}
