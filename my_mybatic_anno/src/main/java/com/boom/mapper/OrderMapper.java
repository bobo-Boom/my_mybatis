package com.boom.mapper;

import com.boom.domain.Order;
import com.boom.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {

    /*
      一对一查询：用户表和订单表的关系为，一个用户有多个订单，一个订单只从属于一个用户

      一对一查询的需求：查询一个订单，与此同时查询出该订单所属的用户
    * */
    @Select("select * from orders")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(property = "user", //要封装的属性名称
                    column = "uid",//要根据那个字段去查询user表
                    javaType = User.class,//要封装的实体类型
                    //select属性，代表查询哪个接口的方法去获取数据
                    one = @One(select = "com.boom.mapper.UserMapper.findById")
            )
    })
    public List<Order> findAll();

    @Select("select * from orders where uid=#{uid}")
    public List<Order> findByUId(int uid);
}
