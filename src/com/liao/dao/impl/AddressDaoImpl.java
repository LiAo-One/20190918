package com.liao.dao.impl;

import java.util.List;

import com.liao.dao.AddressDao;
import com.liao.entity.Address;
import com.liao.entity.User;
import com.liao.mapper.impl.AddressMapper;
import com.liao.mapper.impl.UserMapper;
import com.liao.util.JDBCTemplate;

@SuppressWarnings("all")
public class AddressDaoImpl implements AddressDao {
    /**
     * 添加
     */
    @Override
    public int addAddress(Address address, User user) {
        int count = 0;
        String sql = "insert address (userid,name,useraddress,phone,Remarks,situation )values" +
                "(?,?,?,?,?,?)";
        count = JDBCTemplate.executeUpdate(sql, new UserMapper(),
                user.getId(),
                address.getName(),
                address.getUseraddress(),
                address.getPhone(),
                address.getRemarks(),
                address.getSituation());
//		获取数据库操作对象
//		返回数据库操作结果
        return count;
    }

    /**
     * 删除
     */
    @Override
    public int deleAddress(Address address) {
        String sql = " update address set situation = '销毁' where id = ? ";
        int count = JDBCTemplate.executeUpdate(sql, null,address.getId());
        return count;
    }

    /**
     * 修改
     */
    @Override
    public int modiAddress(Address address) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 查询全部
     */
    @Override
    public int selectAddressAll() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 分页查询
     */
    @Override
    public List<Address> selectAddressByLimit(int pageNum, int pageSize,
                                              Address address, User user) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" a.id ,a.userid ,a.name ,a.situation ,a.useraddress ,a.phone ,a.Remarks");
        buffer.append(" from address a ");
        buffer.append(" inner join user u ");
        buffer.append(" on a.userid = u.id ");
        if (user == null) {
            buffer.append(" where 1 = 1 ");
        } else {
            buffer.append(" where a.userid = " + user.getId());
        }
        if (address != null) {
//			根据姓名
            if (address.getName() != null && address.getName().trim().length() > 0) {
                buffer.append(" and a.name = '" + address.getName() + "'");
            }
//			根据地址关键字
            if (address.getUseraddress() != null && address.getUseraddress().trim().length() > 0) {
                buffer.append(" and a.useraddress like '%" + address.getUseraddress() + "%'");
            }

//			根据联系方式
            if (address.getPhone() != null && address.getPhone().trim().length() > 0) {
                buffer.append(" and a.phone like '%" + address.getPhone() + "%'");
            }

//			根据备注
            if (address.getRemarks() != null && address.getRemarks().trim().length() > 0) {
                buffer.append(" and  a.Remarks like '%" + address.getRemarks() + "%'");
            }

        }
        buffer.append(" LIMIT " + pageSize * (pageNum - 1) + " , " + pageSize);
        String sql = buffer.toString();

        List<Address> addressesList = JDBCTemplate.executeQUery(sql, new AddressMapper(), null);
        return addressesList;
    }

    /**
     * 查询满足条件的条
     */
    @Override
    public List<Address> selectAddressouny(Address address, User user) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" a.id ,a.userid ,a.name ,a.situation ,a.useraddress ,a.phone ,a.Remarks");
        buffer.append(" from address a ");
        buffer.append(" inner join user u ");
        buffer.append(" on a.userid = u.id ");
        if (user == null) {
            buffer.append(" where 1 = 1 ");
        } else {
            buffer.append(" where a.userid = " + user.getId());
        }
        if (address != null) {
//			根据姓名
            if (address.getName() != null && address.getName().trim().length() > 0) {
                buffer.append(" and a.name = '" + address.getName() + "'");
            }
//			根据地址关键字
            if (address.getUseraddress() != null && address.getUseraddress().trim().length() > 0) {
                buffer.append(" and a.useraddress like '%" + address.getUseraddress() + "%'");
            }

//			根据联系方式
            if (address.getPhone() != null && address.getPhone().trim().length() > 0) {
                buffer.append(" and a.phone like '%" + address.getPhone() + "%'");
            }

//			根据备注
            if (address.getRemarks() != null && address.getRemarks().trim().length() > 0) {
                buffer.append(" and  a.Remarks like '%" + address.getRemarks() + "%'");
            }

        }
        String sql = buffer.toString();

        List<Address> addressesList = JDBCTemplate.executeQUery(sql, new AddressMapper(), null);

        return addressesList;
    }

    
    /**
     * 查询用户购物车
     */
	@Override
	public List<Address> selectUserAddressouny(Address address, User user) {
		
		StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" a.id ,a.userid ,a.name ,a.situation ,a.useraddress ,a.phone ,a.Remarks");
        buffer.append(" from address a ");
        buffer.append(" inner join user u ");
        buffer.append(" on a.userid = u.id ");
        buffer.append(" where a.userid = " + user.getId());
        buffer.append(" and a.situation = '" + address.getSituation() + "'");
        String sql = buffer.toString();

        List<Address> addressesList = JDBCTemplate.executeQUery(sql, new AddressMapper(), null);

        return addressesList;
	}
    
    
    

}
