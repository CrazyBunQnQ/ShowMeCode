package com.crazybunqnq.designpattern.factory_abstract;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class Blue implements Color {
    public Blue() {
        System.out.println("创建蓝色");
    }

    @Override
    public void fill() {
        System.out.println("填充蓝色");
    }
}
