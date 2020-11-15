package com.boom.mapper;

import com.boom.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public Boolean save(User user);
    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    public void update(User user);
    @Delete("delete from user where id=#{id}")
    public void delete(int id);

    @Select("select * from user where id=#{id}")
    public User findById(int id);
    @Select("select * from user")
    public List<User> findAll();


    /*
    * 一对多：用户表和订单表的关系为，一个用户有多个订单，一个订单只从属于一个用户

      一对多查询的需求：查询一个用户，与此同时查询出该用户具有的订单
    * */
    @Select("select * from user")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.boom.mapper.OrderMapper.findByUId")

            )
    })
    public List<User> findUserAndOrderAll();

    /*
    * 多对多：用户表和角色表的关系为，一个用户有多个角色，一个角色被多个用户使用

      多对多查询的需求：查询用户同时查询出该用户的所有角色
    * */
    @Select("select * from user")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.boom.mapper.RoleMapper.findByUid")
            )
    })
    public List<User> findUserAndRoleAll();


}
