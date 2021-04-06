package cn.sharit.test;

import cn.sharit.test.bean.User;
import cn.sharit.test.dao.UserMapper;
import cn.sharit.test.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    Logger logger = Logger.getLogger(getClass());

    SqlSession sqlSession;

    @Before
    public void setup() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance();
//        sqlSession = sqlSessionFactory.openSession();
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void cache() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getInstance();
        sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectOne(1);
        System.out.println(user);

        sqlSession.close();

        sqlSession =  sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
        user = mapper.selectOne(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void selectOne() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectOne(1);
        System.out.println(user);
    }

    @Test
    public void selectAll() {
        logger.debug("selectAll");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        users.forEach((System.out::println));
    }

    @Test
    public void insert() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setId(3);
        u.setName("徐进3");
        u.setSex(3);
        int user = mapper.insert(u);
        System.out.println(user);
    }

    @After
    public void after() {
//        sqlSession.commit();
//        sqlSession.close();
    }

}
