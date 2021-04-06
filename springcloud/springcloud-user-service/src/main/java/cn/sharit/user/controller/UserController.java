package cn.sharit.user.controller;

import cn.sharit.provider.entity.UserEntity;
import cn.sharit.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    UserEntity findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/user/test")
    String testLoadBalance() {
        return instanceId;
    }

}
