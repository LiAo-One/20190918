package com.liao.service;

import java.util.List;

import com.liao.entity.Order;
import com.liao.entity.User;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public interface OrderService {
    /**
     * 添加
     *
     * @param user
     * @return
     */
    public ResJson addOrder(Order order);

    /**
     * 删除
     *
     * @param order
     * @return
     */
    public ResJson deleOrder(Order order);

    /**
     * 修改
     *
     * @param order
     * @return
     */
    public ResJson modiOrder(Order order);

    /**
     * 查询所有
     */
    public ResJson selectOrderAll();

    /**
     * 分页查询
     *
     * @return
     */
    public ResJson selectOrderByLimit(int pageNum, int pageSize,
                                      Order order, User user);

    /**
     * 根据条件查询数据条数
     *
     * @param
     * @return
     */
    public int selectOrderouny(Order order, User user);
    
    /**
     * 根据ID查询所有订单
     * @param user
     * @return
     */
    public ResJson selectUserAllOrderou(Order order,User user);
}
