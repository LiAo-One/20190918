package com.liao.service;


import java.util.List;

import com.liao.entity.Address;
import com.liao.entity.User;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public interface AddressService {
    /**
     * 添加
     *
     * @param user
     * @return
     */
    public ResJson addAddress(Address address, User user);

    /**
     * 删除
     *
     * @param address
     * @return
     */
    public ResJson deleAddress(Address address);

    /**
     * 修改
     *
     * @param address
     * @return
     */
    public ResJson modiAddress(Address address);

    /**
     * 查询所有
     */
    public ResJson selectAddressAll();

    /**
     * 分页查询
     *
     * @return
     */
    public ResJson selectAddressByLimit(int pageNum, int pageSize,
                                        Address address, User user);

    /**
     * 根据条件查询数据条数
     *
     * @param
     * @return
     */
    public int selectAddressouny(Address address, User user);
    
    
    /**
     * 查询用户地址
     * @param address
     * @param user
     * @return
     */
    public ResJson selectUserAddressouny(Address address, User user);
}
