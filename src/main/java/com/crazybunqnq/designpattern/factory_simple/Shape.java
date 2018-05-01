package com.crazybunqnq.designpattern.factory_simple;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public interface Shape {
    public static final String CIRCLE = "CIRCLE";
    public static final String RECTANGLE = "RECTANGLE";
    public static final String SQUARE = "SQUARE";

    void draw();
}
