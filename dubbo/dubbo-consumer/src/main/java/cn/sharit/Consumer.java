package cn.sharit;

import cn.sharit.entity.User;
import cn.sharit.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

    public static void main(String[] args) {
        //Prevent to get IPV6 address,this way only work in debug mode
        //But you can pass use -Djava.net.preferIPv4Stack=true,then it work well whether in debug mode or not
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-consumer.xml"});
        context.start();
        UserService userService = (UserService) context.getBean("userService"); // get remote service proxy

        while (true) {
            try {
                Thread.sleep(1000);
                User user = userService.findById("1"); // call remote method
                System.out.println(user.getId() + " " + user.getName() + " " + user.getAge()); // get result

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }


        }
    }
}
