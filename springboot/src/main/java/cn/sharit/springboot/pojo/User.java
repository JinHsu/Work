package cn.sharit.springboot.pojo;

import org.springframework.beans.factory.InitializingBean;

public class User implements InitializingBean {

    public void sayHello() {
        System.out.println("hello");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cn.sharit.springboot.pojo.User\t\t" + "afterPropertiesSet");
    }
}
