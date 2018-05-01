package com.crazybunqnq.designpattern.factory.simple;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("执行长方形的 draw 方法");
    }
}
