package cn.sharit.springboot.autoconfig;

import cn.sharit.springboot.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class TestAutoConfiguration {

    @Bean
    public User user() {
        return new User();
    }

}
