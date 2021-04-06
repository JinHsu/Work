package cn.sharit.order.controller;

import cn.sharit.order.feign.UserServiceFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private static final String USER_SERVICE = "springcloud-user-service";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private UserServiceFeign userServiceFeign;

    @GetMapping("/order")
    public String order() {
        return restTemplate.getForEntity("http://" + USER_SERVICE + "/user/test", String.class).getBody();
    }

    @GetMapping("/order2")
    public String order2() {
        return userServiceFeign.userTest();
    }

    @GetMapping("/order3")
    @HystrixCommand(fallbackMethod = "circuitBreaker")
    public String order3() {
        return userServiceFeign.userTest();
    }

    // 熔断方法
    public String circuitBreaker() {
        return "circuitBreaker";
    }

}
