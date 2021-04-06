package cn.sharit.ioc.injection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class IoCTest {

    private ApplicationContext context;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testWire() {
        Object a = context.getBean("a");
        Object b = context.getBean("b");

        System.out.println(a);
        System.out.println(b);
    }

}

@Component
class Foo {

    private Bar bar;

    public Bar getBar() {
        return bar;
    }

    @Autowired
    public void setBar(Bar bar) {
        this.bar = bar;
    }
}

@Component
class Bar {

    private Foo foo;

    public Foo getFoo() {
        return foo;
    }

    @Autowired
    public void setFoo(Foo foo) {
        this.foo = foo;
    }
}