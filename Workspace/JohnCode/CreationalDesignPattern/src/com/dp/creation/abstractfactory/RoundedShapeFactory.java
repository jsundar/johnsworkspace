package com.dp.creation.abstractfactory;

public class RoundedShapeFactory extends AbstractShapeFactory {

	public Shape getShape(String shape) {
		if(shape == null || shape.equals("")) {
			return null;
		} else if(shape.equals("SQUARE")) { 
			return new RoundedSquare();
		} else if(shape.equals("CIRCLE")) {
			return new RoundedCircle();
		} else if(shape.equals("RECTANGLE")) {
			return new RoundedRectangle();
		} else {
			return null;
		}
	}

}
