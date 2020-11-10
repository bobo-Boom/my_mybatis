package com.boom.test;


import com.boom.dao.UserMapper;
import com.boom.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {

    @org.junit.Test
    public void testPageHelper()throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(2,2);

        List<User> userList = userMapper.findAll();

        for (User user:userList) {
            System.out.println(user);
            
        }
        PageInfo<User> userPageInfo = new PageInfo<User>(userList);
        System.out.println("当前页："+userPageInfo.getPageNum());
        System.out.println("每页显示条数"+userPageInfo.getPageSize());
        System.out.println("总条数："+userPageInfo.getTotal());
        System.out.println("当前页条数 "+userPageInfo.getSize());


    }
}
