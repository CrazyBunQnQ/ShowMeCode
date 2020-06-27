package com.crazybunqnq.designpattern.factory_abstract;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class Rectange implements Shape {
    public Rectange() {
        System.out.println("创建长方形");
    }

    @Override
    public void draw() {
        System.out.println("执行长方形的 draw 方法");
    }
}
