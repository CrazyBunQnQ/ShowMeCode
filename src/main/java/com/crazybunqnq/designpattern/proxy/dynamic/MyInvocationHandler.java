package com.crazybunqnq.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by CrazyBunQnQ on 17-6-6.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Subject subject;

    public MyInvocationHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----------插入前置通知代码-----------");
        Object rs = method.invoke(subject, args);
        System.out.println("----------插入前置通知代码-----------");
        return rs;
    }
}
