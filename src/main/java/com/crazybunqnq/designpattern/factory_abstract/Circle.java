package com.crazybunqnq.designpattern.factory_abstract;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class Circle implements Shape {
    public Circle() {
        System.out.println("创建圆形");
    }

    @Override
    public void draw() {
        System.out.println("执行圆形的 draw 方法");
    }
}
