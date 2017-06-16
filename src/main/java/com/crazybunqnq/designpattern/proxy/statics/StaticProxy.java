package com.crazybunqnq.designpattern.proxy.statics;

/**
 * 静态代理类，实现 Subject 接口
 * Created by CrazyBunQnQ on 17-6-6.
 */
public class StaticProxy implements Subject {
    private Subject subject;

    public StaticProxy() {}

    public StaticProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("begin");
        subject.request();
        System.out.println("begin");
    }
}
