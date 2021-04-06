package cn.sharit.springboot;

import cn.sharit.springboot.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {SpringApplicationAdminJmxAutoConfiguration.class})
public class StartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StartApplication.class, args);
        User user = context.getBean(User.class);
        user.sayHello();
    }

}
