package com.liao.service;


import java.util.List;

import com.liao.entity.User;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public interface UserService {
    /**
     * 登录
     *
     * @param
     * @return
     */
    public ResJson login(User user);

    /**
     * 添加
     *
     * @param user
     * @return
     */
    public ResJson addUser(User user);

    /**
     * 删除
     *
     * @param user
     * @return
     */
    public ResJson deleUser(User user);

    /**
     * 修改
     *
     * @param user
     * @return
     */
    public ResJson modiUser(User user);

    /**
     * 模糊查询
     *
     * @param
     * @return
     */
    public void showUser(User user);

    /**
     * 查询所有
     */
    public ResJson selectUserAll();

    /**
     * 分页查询
     *
     * @return
     */
    public ResJson selectUserByLimit(int pageNum, int pageSize, User user);


    /**
     * 按照条件查询数量
     *
     * @param
     * @return
     */
    public int selectUserCouny(User user);

    /**
     * 判断账号是否存在
     *
     * @param user
     * @return
     */
    public ResJson repeatName(User user);
    
    
    /**
     * 查询用户余额
     * @param user
     * @return
     */
    public ResJson userPay(User user);
    
    
    /**
     *  用户充值
     * @param user
     * @return
     */
    public ResJson userRechargs(User user);
}
