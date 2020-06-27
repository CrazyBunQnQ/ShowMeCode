package com.crazybunqnq.designpattern.factory_abstract;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Shape getShape(String shape);
}
