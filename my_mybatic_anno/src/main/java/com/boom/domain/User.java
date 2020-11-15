package com.boom.domain;

import java.util.Date;
import java.util.List;

public class User {

    private int id;
    private String username;
    private String passwd;
    private Date birthday;

    //当前用户具备哪些角色
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    //描述的是当前用户具有的订单
    private List<Order> orderList;
    public List<Order> getOrderList() {
        return orderList;
    }
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return passwd;
    }

    public void setPasswordddd(String password) {
        this.passwd = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + passwd + '\'' +
                ", birthday=" + birthday +
                ", roleList=" + roleList +
                '}';
    }
}
