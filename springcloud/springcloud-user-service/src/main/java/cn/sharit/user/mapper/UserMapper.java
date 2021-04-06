package cn.sharit.user.mapper;

import cn.sharit.provider.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    int insert(UserEntity userEntity);

    UserEntity findById(Long id);

}
