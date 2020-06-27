package com.crazybunqnq.designpattern.factory_abstract;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class Square implements Shape {
    public Square() {
        System.out.println("创建正方形");
    }

    @Override
    public void draw() {
        System.out.println("执行正方形的 draw 方法");
    }
}
