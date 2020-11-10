package com.boom.dao;

import com.boom.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    public List<User> findAll() throws IOException;
    public User findById(int id);
    public User findByConditon(User user);
    public List<User> findByIds(List ids);
    public void addUser(User user);
}
