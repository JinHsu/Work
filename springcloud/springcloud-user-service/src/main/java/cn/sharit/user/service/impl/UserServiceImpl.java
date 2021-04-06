package cn.sharit.user.service.impl;

import cn.sharit.provider.entity.UserEntity;
import cn.sharit.provider.service.UserService;
import cn.sharit.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity insert(UserEntity userEntity) {
        userMapper.insert(userEntity);
        return findById(userEntity.getId());
    }

    @Override
    public UserEntity findById(Long id) {
        return userMapper.findById(id);
    }
}
