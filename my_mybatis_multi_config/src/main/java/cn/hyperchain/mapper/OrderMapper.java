package cn.hyperchain.mapper;

import cn.hyperchain.domain.Order;

import java.util.List;

public interface OrderMapper {
    //查询所有订单方法
    public List<Order> findAll();

}
