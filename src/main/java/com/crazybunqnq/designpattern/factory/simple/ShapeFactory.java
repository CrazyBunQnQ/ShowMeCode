package com.crazybunqnq.designpattern.factory.simple;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class ShapeFactory {
    public static final String CIRCLE = "CIRCLE";
    public static final String RECTANGLE = "RECTANGLE";
    public static final String SQUARE = "SQUARE";

    public Shape getShape(String shapeType) {
        if (shapeType == null || "".equals(shapeType)) {
            return null;
        }
        switch (shapeType.toUpperCase()) {
            case CIRCLE:
                return new Circle();
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
                return new Square();
            default:
                return null;
        }
    }
}
