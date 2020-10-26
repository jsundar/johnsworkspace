package com.dp.creation.abstractfactory;

public class FactoryProducer {
	
	public static AbstractShapeFactory getShapeFactory(boolean isRounded) {
		if(isRounded) {
			return new RoundedShapeFactory();
		} else {
			return new ShapeFactory();
		}
	}

}
