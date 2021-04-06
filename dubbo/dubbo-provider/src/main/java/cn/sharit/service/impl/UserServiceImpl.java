package cn.sharit.service.impl;

import cn.sharit.entity.User;
import cn.sharit.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User findById(String id) {
        User u = new User();
        u.setId("1");
        u.setName("徐进");
        u.setAge(30);
        return u;
    }
}
