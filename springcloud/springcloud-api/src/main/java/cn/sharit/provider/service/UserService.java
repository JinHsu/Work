package cn.sharit.provider.service;

import cn.sharit.provider.entity.UserEntity;

public interface UserService {

    UserEntity insert(UserEntity userEntity);

    UserEntity findById(Long id);

}
