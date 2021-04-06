package cn.sharit.order.feign;

import cn.sharit.provider.entity.UserEntity;
import cn.sharit.provider.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {

            @Override
            public UserEntity insert(UserEntity userEntity) {
                return null;
            }

            @Override
            public UserEntity findById(Long id) {
                return new UserEntity();
            }
        };
    }
}
