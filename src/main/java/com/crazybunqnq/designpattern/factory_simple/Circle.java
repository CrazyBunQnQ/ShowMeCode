package com.crazybunqnq.designpattern.factory_simple;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("执行圆形的 draw 方法");
    }
}
