package cn.sharit.dp.结构型.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MiPhoneInvocationHandler implements InvocationHandler {

    private final Object target;

    public MiPhoneInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行目标方法");
        Object ret = method.invoke(target, args);
        System.out.println("目标方法执行完成");
        return ret;
    }
}
