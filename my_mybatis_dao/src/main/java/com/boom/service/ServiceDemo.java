package com.boom.service;

import com.boom.dao.UserMapper;
import com.boom.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceDemo {
    public static void main(String[]  args)throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
   /*     List<User> all = userMapper.findAll();
        System.out.println(all);
        User user = userMapper.findById(1);
        System.out.println(user);

        User user1 = new User();
        user1.setId(1);
        user1.setUsername("long");
        User userMapperByCondtion = userMapper.findByConditon(user1);
        System.out.println(userMapperByCondtion);

        List list= new ArrayList();
        list.add(1);
        List<User> userList= userMapper.findByIds(list);
        System.out.println(userList);
*/
        User user2 = new User();

        user2.setUsername("lihhh");
        user2.setPassword("lihai");
        user2.setBirthday(new Date());
        System.out.println(new Date());

        userMapper.addUser(user2);
        sqlSession.commit();
        sqlSession.close();

    }

}
