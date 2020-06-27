package com.crazybunqnq.designpattern.factory_abstract;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class Red implements Color {
    public Red() {
        System.out.println("创建红色");
    }

    @Override
    public void fill() {
        System.out.println("填充红色");
    }
}
