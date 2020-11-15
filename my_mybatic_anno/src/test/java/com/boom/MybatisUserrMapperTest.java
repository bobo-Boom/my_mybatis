package com.boom;

import com.boom.domain.User;
import com.boom.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisUserrMapperTest {

    private  UserMapper mapper;
    @Before
    public void befor()throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSave(){
        User user =new User();
        user.setUsername("bobo");
        user.setPasswordddd("2432");

        Boolean aBoolean = mapper.save(user);
        System.out.println(aBoolean);
    }
    @Test
    public void testFindAll(){
        List<User> userList = mapper.findAll();
        System.out.println(userList);
    }
    @Test
    public void testFindUserAndOrderAll(){
        List<User> userAndOrderAll = mapper.findUserAndOrderAll();
        System.out.println(userAndOrderAll);
    }
    @Test
    public void testFindUserAndRoleAll(){
        List<User> userAndRoleAll = mapper.findUserAndRoleAll();
        System.out.println(userAndRoleAll);
    }
}
