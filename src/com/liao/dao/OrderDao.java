package com.liao.dao;

import java.util.List;

import com.liao.entity.Order;
import com.liao.entity.User;

public interface OrderDao {
    /**
     * 添加
     *
     * @param order
     * @return
     */
    public int addOrder(Order order);

    /**
     * 删除
     *
     * @param order
     * @return
     */
    public int deleOrder(Order order);

    /**
     * 修改
     *
     * @param order
     * @return
     */
    public int modiOrder(Order order);

    /**
     * 查询所有
     */
    public int selectOrderAll();

    /**
     * 分页查询
     *
     * @return
     */
    public List<Order> selectOrderByLimit
    (int pageNum, int pageSize, Order order, User user);

    /**
     * 根据条件查询数据条数
     *
     * @param
     * @return
     */
    public List<Order> selectOrderouny(Order order, User user);
    
    /**
     * 查询用户所有订单
     * @param user
     * @return
     */
    public List<Order> selectUserAllOrderou(Order order, User user);
    
    
    
    
}
