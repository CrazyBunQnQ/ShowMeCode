package design.pattern.proxy;

import org.junit.Test;
import proxy.statics.RealSubject;
import proxy.statics.StaticProxy;

/**
 * 静态代理测试
 * Created by CrazyBunQnQ on 17-6-6.
 */
public class StaticProxyTest {
    @Test
    public void proxyTest() {
        //目标对象
        RealSubject subject = new RealSubject();
        //代理对象
        StaticProxy proxy = new StaticProxy(subject);
        proxy.request();
    }
}
