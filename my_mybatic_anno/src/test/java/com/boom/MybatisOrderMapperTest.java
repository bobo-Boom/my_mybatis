package com.boom;

import com.boom.domain.Order;
import com.boom.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisOrderMapperTest {

    private OrderMapper mapper;
    @Before
    public void befor()throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(OrderMapper.class);
    }
    @Test
    public void testFindAll(){
        List<Order> orderList = mapper.findAll();
        System.out.println(orderList);
    }
    @Test
    public void testFindByUId(){
        List<Order> orderList = mapper.findByUId(2);
        System.out.println(orderList);
    }
}
