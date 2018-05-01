package com.crazybunqnq.designpattern.factory.simple;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("执行正方形的 draw 方法");
    }
}
