package com.crazybunqnq.designpattern.factory_simple;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType == null || "".equals(shapeType)) {
            return null;
        }
        switch (shapeType.toUpperCase()) {
            case Shape.CIRCLE:
                return new Circle();
            case Shape.RECTANGLE:
                return new Rectangle();
            case Shape.SQUARE:
                return new Square();
            default:
                return null;
        }
    }
}
