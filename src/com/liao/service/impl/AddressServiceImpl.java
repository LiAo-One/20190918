package com.liao.service.impl;

import java.util.List;

import com.liao.dao.AddressDao;
import com.liao.entity.Address;
import com.liao.entity.User;
import com.liao.exception.AddBookExcoption;
import com.liao.exception.DeleExcoption;
import com.liao.exception.ShowIDExcoption;
import com.liao.factory.ObjectFactory;
import com.liao.service.AddressService;
import com.liao.util.ResJson;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao = (AddressDao) ObjectFactory.getBean("AddressDao");

    /**
     * 添加
     *
     * @param user
     * @return
     */
    @Override
    public ResJson addAddress(Address address, User user) {
        ResJson json = new ResJson();
        int count = 0;
        try {
//			判断添加参数是否为空
            if (address == null || user == null) {
                throw new AddBookExcoption("添加异常： 添加的数据为空");
            }
//			判断userid是否为空
            if (user.getId() == null || user.getId().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 数据不完整");
            }
//			判断添加姓名是否唯空
            if (address.getName() == null || address.getName().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 姓名为空");
            }
//			判断姓名是否为空
            if (address.getUseraddress() == null || address.getUseraddress().trim().length() == 0) {
                throw new AddBookExcoption("添加异常：地址为空");
            }
//			判断电话是否为空
            if (address.getPhone() == null || address.getPhone().trim().length() == 0) {
                throw new AddBookExcoption("添加异常: 电话为空");
            }
//			电话正则判断
            if (!address.getPhone().matches
                    ("^[1](([3][0-9])|" +
                            "([4][5,7,9])|" +
                            "([5][0-9])|" +
                            "([6][6])|" +
                            "([7][3,5,6,7,8]|" +
                            "([8][0-9])|" +
                            "([9][8,9]))" +
                            "[0-9]{8}$)")) {
                throw new AddBookExcoption("添加异常 ：电话不合法");
            }
//			如果备注为空则赋默认值
            if (address.getRemarks() == null || address.getRemarks().trim().length() == 0) {
                address.setId("无");
            }
//			执行添加
            count = addressDao.addAddress(address, user);
//			判断添加是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("添加成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
        }
        return json;
    }

    /**
     * 删除
     *
     * @param address
     * @return
     */
    @Override
    public ResJson deleAddress(Address address) {
        ResJson json = new ResJson();
        int count = 0;
        try {
//			判断添加参数是否为空
            if (address == null) {
                throw new DeleExcoption("异常： 数据为空");
            }

            if (address.getId() == null || address.getId().trim().length() == 0) {
                throw new DeleExcoption("异常： id为空");
            }

            if (address.getSituation() == null || address.getSituation().trim().length() == 0) {
                throw new DeleExcoption("状态不存在");
            }

//			执行添加
            count = addressDao.deleAddress(address);
//			判断添加是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("成功");
            } else {
                json.setSub(true);
                json.setStr("失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
        }
        return json;
    }

    /**
     * 修改
     *
     * @param address
     * @return
     */
    @Override
    public ResJson modiAddress(Address address) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 查询所有
     */
    @Override
    public ResJson selectAddressAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 分页查询
     *
     * @return
     */
    @Override
    public ResJson selectAddressByLimit(int pageNum, int pageSize,
                                        Address address, User user) {
        ResJson rejs = new ResJson();
//		判断数据是否合法
        try {
            if (pageNum < 1) {
                throw new ShowIDExcoption("pageNum不合法");
            }

            if (pageSize < 1) {
                throw new ShowIDExcoption("pageNum不合法");
            }
//			获取查询的集合
            List<Address> addressesList = addressDao.selectAddressByLimit(pageNum, pageSize,
                    address, user);
//			查询成功
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(addressesList);
        } catch (Exception e) {
//			失败
            rejs.setStr(e.getMessage());
            rejs.setSub(false);
            rejs.setList(null);
        }
        return rejs;
    }

    /**
     * 根据条件查询数据条数
     *
     * @param
     * @return 返回集合长度
     */
    @Override
    public int selectAddressouny(Address address, User user) {
//		存储查询的集合的长度
        int count = 0;
//		获取返回值
        List<Address> addressesList = addressDao.selectAddressouny(address, user);
        count = addressesList.size();
//		返回长度
        return count;
    }

    /**
     * 查询用户地址数据
     */
    @Override
    public ResJson selectUserAddressouny(Address address, User user) {
        ResJson rejs = new ResJson();
//		判断数据是否合法
        try {
            if (user == null) {
                throw new ShowIDExcoption("用户不存在");
            }

            if (address.getSituation() == null || address.getSituation().trim().length() == 0) {
                throw new DeleExcoption("地址状态异常");
            }
//			获取查询的集合
            List<Address> addressesList = addressDao.selectUserAddressouny(address, user);
//			查询成功
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(addressesList);
        } catch (Exception e) {
//			失败
            rejs.setStr(e.getMessage());
            rejs.setSub(false);
            rejs.setList(null);
        }
        return rejs;
    }

}
