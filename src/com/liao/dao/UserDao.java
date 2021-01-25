package com.liao.dao;


import java.util.List;

import com.liao.entity.User;

public interface UserDao {

    /**
     * 登录
     *
     * @param
     * @return
     */
    public List<User> login(User user);

    /**
     * 添加
     *
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 删除
     *
     * @param user
     * @return
     */
    public int deleUser(User user);

    /**
     * 修改
     *
     * @param user
     * @return
     */
    public int modiUser(User user);

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
    public List<User> selectUserAll();

    /**
     * 分页查询
     *
     * @return
     */
    public List<User> selectUserByLimit(int pageNum, int pageSize, User user);

    /**
     * 根据条件查询数据条数
     *
     * @param
     * @return
     */
    public List<User> selectUserouny(User user);

    /**
     * 判断账号是否存在
     *
     * @param user
     * @return
     */
    public List<User> repeatName(User user);
    
    
    /**
     * 充值
     * @param user
     * @return
     */
    public int userPay(User user);
    
    
    /**
     * 根据ID查询用户余额
     * @param user
     * @return
     */
    public List<User> userIdBalance(User user);
}
