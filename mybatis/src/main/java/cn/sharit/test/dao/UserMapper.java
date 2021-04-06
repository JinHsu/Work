package cn.sharit.test.dao;

import cn.sharit.test.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 接口方法不能重载，因为cn.sharit.test.dao.UserMapper#selectOne是唯一的
 */
public interface UserMapper {

    int insert(User user);

//    @Select("select * from user where id = #{id}")
    User selectOne(int id);

    List<User> selectAll();

}
