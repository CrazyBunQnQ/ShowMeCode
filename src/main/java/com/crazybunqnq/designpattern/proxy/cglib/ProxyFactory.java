package com.crazybunqnq.designpattern.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib 子类代理工厂
 * 对 RealSubject 在内存中动态构建一个子类对象
 * Created by CrazyBunQnQ on 17-6-6.
 */
public class ProxyFactory implements MethodInterceptor {

    //维护目标对象
    private RealSubject target;

    public ProxyFactory(RealSubject target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public RealSubject getProxyInstance() {
        //1.工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(target.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类（代理对象）
        return (RealSubject) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("---------前置通知代码---------");
        //执行目标对象的方法
        Object returnValue = method.invoke(target, objects);
        System.out.println("---------后置通知代码---------");
        return returnValue;
    }
}
