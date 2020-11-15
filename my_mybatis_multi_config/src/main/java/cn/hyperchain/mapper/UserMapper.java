package cn.hyperchain.mapper;

import cn.hyperchain.domain.User;

import java.util.List;

public interface UserMapper {
    //查询所有用户
    List<User> findAll();
    List<User> findUserAndRuleAll();
}
