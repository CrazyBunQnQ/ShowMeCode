package designmodle.proxy;

import org.junit.Test;
import com.crazybunqnq.design.pattern.proxy.dynamic.MyInvocationHandler;
import com.crazybunqnq.design.pattern.proxy.dynamic.RealSubject;
import com.crazybunqnq.design.pattern.proxy.dynamic.Subject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Created by CrazyBunQnQ on 17-6-6.
 */
public class DynamicProxyTest {
    @Test
    public void proxyTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //生成 $Proxy 的 class 文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //获取动态代理类
        Class proxyClass = Proxy.getProxyClass(Subject.class.getClassLoader(), Subject.class);
        //获得代理类的构造函数，并传入参数类型 InvocationHandler.class
        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
        //通过构造函数来创建动态代理对象，将自定义的 InvocationHandler 实例传入
        Subject subject = (Subject) constructor.newInstance(new MyInvocationHandler(new RealSubject()));
        //通过代理对象调用目标方法
        subject.sayHello();
    }

    @Test
    public void proxyTest2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //生成 $Proxy 的 class 文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),//加载接口的类加载器
                new Class[]{Subject.class},//一组接口
                new MyInvocationHandler(new RealSubject()));//自定义的 InvocationHandler
        subject.sayHello();
    }
}
