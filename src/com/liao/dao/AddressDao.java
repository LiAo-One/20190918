package com.liao.dao;

import java.util.List;

import com.liao.entity.Address;
import com.liao.entity.User;

public interface AddressDao {

    /**
     * 添加
     *
     * @param user
     * @return
     */
    public int addAddress(Address address, User user);

    /**
     * 删除
     *
     * @param address
     * @return
     */
    public int deleAddress(Address address);

    /**
     * 修改
     *
     * @param address
     * @return
     */
    public int modiAddress(Address address);

    /**
     * 查询所有
     */
    public int selectAddressAll();

    /**
     * 分页查询
     *
     * @return
     */
    public List<Address> selectAddressByLimit(int pageNum, int pageSize, Address address, User user);

    /**
     * 根据条件查询数据条数
     *
     * @param
     * @return
     */
    public List<Address> selectAddressouny(Address address, User user);
    
    
    /**
     * 查询用户地址
     * @param address
     * @param user
     * @return
     */
    public List<Address> selectUserAddressouny(Address address, User user);


}
