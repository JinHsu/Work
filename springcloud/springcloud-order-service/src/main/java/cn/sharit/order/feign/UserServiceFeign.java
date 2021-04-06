package cn.sharit.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "springcloud-user-service")
public interface UserServiceFeign {

    @GetMapping("/user/test")
    String userTest();

}
