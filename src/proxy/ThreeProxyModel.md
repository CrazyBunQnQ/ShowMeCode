---
title: Java 的三种代理模式
date: 2017-6-6 09:32
categories: 设计模式
tag: 
- Proxy
---

代理（Proxy）是一种设计模式，提供了对目标对象另外的访问方式，即通过代理对象访问目标对象，这样做的好处是：可以在目标对象实现的基础上，增强额外的功能操作，即扩展目标对象的功能。
这里使用到编程中的一个思想：不要随意去修改别人已经写好的代码或者方法，如果需要修改，可以通过代理的方式来扩展该方法。

<!--more-->

举个例子来说明代理的作用：
假设我们想邀请一位明星，那么并不是直接连接明星，而是联系明星的经纪人，来达到同样的目的。明星就是一个目标对象，他只要负责活动中的节目，而其他琐碎的事情就交给他的代理人（经纪人）来解决。这就是代理思想在现实中的一个例子。
用图表示如下：
![代理模式](http://wx4.sinaimg.cn/mw690/a6e9cb00ly1fgb9aigh6lj20ez08ft8r.jpg)
1. RealSubject 是委托类，Proxy 是代理类；
2. Subject是委托类和代理类的接口；
3. request() 是委托类和代理类的共同方法。
>代理模式的关键点是：代理对象与目标对象：代理对象是对目标对象的扩展，并会调用目标对象。

## 静态代理
静态代理在使用时，需要定义接口或者父类，被代理对象与代理对象一起实现相同的接口或者是继承相同父类。

下面举个例子来解释：
模拟 request 动作，定义一个 request 动作的接口：Subject.java，然后目标对象（RealSubject.java）实现这个接口的方法 request()，此时如果使用静态代理方式，就需要在代理对象（Proxy.java）中也实现 Subject 接口。调用的时候通过调用代理对象的方法来调用目标对象。
>需要注意的是，**代理对象与目标对象要实现相同的接口，然后通过调用相同的方法来调用目标对象的方法。**

### 代码示例：
接口：Subject.java
```java
public interface Subject {
    void request();
}
```
目标对象：RealSubject.java
```java
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject");
    }
}
```
代理类：Proxy.java
```java
public class Proxy implements Subject {
    private Subject subject;

    public Proxy() {}

    public Proxy(Subject subject) {
        this.subject = subject;
    }
    @Override
    public void request() {
        System.out.println("begin");
        subject.request();
        System.out.println("begin");
    }
}
```
测试类：StaticProxyTest.java
```java
public class StaticProxyTest {
    @Test
    public void proxyTest() {
        //目标对象
        RealSubject subject = new RealSubject();
        //代理对象
        Proxy proxy = new Proxy(subject);
        proxy.request();
    }
}
```
### 静态代理总结
- 可以在不修改目标对象功能的前提下，对目标对象进行扩展。
- 缺点：因为代理对象需要与目标对象实现一样的接口，所以会有很多代理类，类太多。同时，一旦接口增加方法，目标对象与代理对象都要维护。

如何解决静态代理中的缺点呢？答案是可以使用动态代理方式。

<br/>
## JDK 动态代理
动态代理中，代理类并不是在 Java 代码中实现，而是在运行时期生成，相比静态代理，动态代理可以很方便的对委托类的方法进行统一处理，动态代理分为 JDK 动态代理和 cglib 动态代理。下面先说说 JDK 动态代理。

使用 JDK 动态代理模式必须要让代理类和目标类实现相同的接口，客户端通过代理类来调用目标方法，代理类会将所有的方法调用分派到目标对象上反射执行，还可以在分派过程中添加“前置通知”和“后置通知”（如在调用目标方法前家教严权限，在调用完目标方法后打印日志等）等功能。
![JDK 动态代理](http://wx1.sinaimg.cn/mw690/a6e9cb00ly1fgbcvjspu1j20le0f60tb.jpg)

使用动态代理的五大步骤
1. 通过实现 InvocationHandler 接口来自定义自己的 InvocationHandler
2. 通过 Proxy.getProxyClass 获得动态代理类
3. 通过反射机制获得代理类的构造方法，方法签名为 getConstructor(InvocationHandler.class)
4. 通过构造函数获得代理对象并将自定义的 InvocationHandler 实例对象作为参数传入
5. 通过代理对象调用目标方法

### 代码示例：
目标对象的接口：Subject.java
```java
public interface Subject {
    void sayHello();
}
```
目标对象：RealSubject.java
```java
public class RealSubject implements Subject {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
```
自定义 InvocationHandler：MyInvocationHandler.java
```java
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
```
测试类：DynamicProxyTest.java
```java
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
```
Proxy 类中还有个将 2~4 步骤封装好的简便方法来创建动态代理对象，其方法签名为：newProxyInstance(ClassLoader loader,Class<?>[] instance, InvocationHandler h)，如下例：
```java
@Test
public void proxyTest2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    //生成 $Proxy 的 class 文件
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),//加载接口的类加载器
            new Class[]{Subject.class},//一组接口
            new MyInvocationHandler(new RealSubject()));//自定义的 InvocationHandler
    subject.sayHello();
}
```
输出结果一样。

**JDK 代理有以下特点：**
- 代理对象，不需要实现接口
- 代理对象的生成，是利用 JDK 的 API 动态的在内存中构建代理对象（需要我们指定创建代理对象/目标对象实现的接口类型）
- JDK 代理也叫做接口代理

<br/>
## Cglib 代理
上面的静态代理和 JDK 动态代理模式都要求目标对象实现一个接口，但是有时候目标对象只是一个单独的对象，并没有实现任何的接口，这个时候就可以使用以目标对象子类的方式类实现代理，这种方法就叫做：Cglib 代理

Cglib 代理也叫作子类代理，它是在内存中构建一个子类对象从而实现对目标对象功能的扩展。
- JDK 的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口，如果想代理没有实现接口的类，就可以使用Cglib实现。
- Cglib 是一个强大的高性能的代码生成包，它可以在运行期扩展 Java 类与实现 Java 接口。它广泛的被许多 AOP 的框架使用，例如 Spring AOP 和 synaop，为他们提供方法的 interception（拦截）。
- Cglib 包的底层是通过使用一个小而快的字节码处理框架 ASM 来转换字节码并生成新的类。不鼓励直接使用 ASM，因为它要求你必须对 JVM 内部结构包括 class 文件的格式和指令集都很熟悉。

**Cglib子类代理实现方法：**
1. 需要引入 Cglib 的 jar 文件，但是 Spring 的核心包中已经包括了 Cglib 功能，所以直接引入 `spring-core-x.x.x.jar` 即可。
2. 引入依赖包后,就可以在内存中动态构建子类。
3. 代理的类不能定义为 final，否则会报错。
4. 目标对象的方法如果定义为 final 或 static，那么就不会被拦截，即不会执行目标对象额外的业务方法。

### 代码示例：
目标对象：RealSubject.java
```java
public class RealSubject {
    public void doPrint() {
        System.out.println("目标对象的方法");
    }
}
```
Cglib 代理工厂：ProxyFactory.java
```java
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
```
测试类：CglibProxyTest.java
```java
public class CglibProxyTest {
    @Test
    public void test() {
        //目标对象
        RealSubject target = new RealSubject();
        //代理对象
        RealSubject proxy = (RealSubject) new ProxyFactory(target).getProxyInstance();
        //执行代理对象的方法
        proxy.doPrint();
    }
}
```
>在 Spring 的 AOP 编程中：
如果加入容器的目标对象有实现接口，用 JDK 代理
如果目标对象没有实现接口，用 Cglib 代理