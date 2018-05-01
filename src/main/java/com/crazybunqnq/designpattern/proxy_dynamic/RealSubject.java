package com.crazybunqnq.designpattern.proxy_dynamic;

/**
 * Created by CrazyBunQnQ on 17-6-6.
 */
public class RealSubject implements Subject {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
