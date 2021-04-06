package cn.sharit.dp.结构型.代理模式.动态代理;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理：代理的目标对象需要实现接口，需要一个InvocationHandler
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {

        PhoneFactory factory = new MiPhoneFactory();

        PhoneFactory instance = (PhoneFactory) Proxy.newProxyInstance(
                factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                new MiPhoneInvocationHandler(factory)
        );

        instance.make();

    }

}
