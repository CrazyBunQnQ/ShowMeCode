package com.crazybunqnq.designpattern.proxy.cglib;

/**
 * 目标对象，没有实现任何接口
 * Created by CrazyBunQnQ on 17-6-6.
 */
public class RealSubject {
    public void doPrint() {
        System.out.println("目标对象的方法");
    }
}
