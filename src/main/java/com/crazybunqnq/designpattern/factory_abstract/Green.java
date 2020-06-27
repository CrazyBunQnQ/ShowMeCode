package com.crazybunqnq.designpattern.factory_abstract;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class Green implements Color {
    public Green() {
        System.out.println("创建绿色");
    }

    @Override
    public void fill() {
        System.out.println("填充绿色");
    }
}
