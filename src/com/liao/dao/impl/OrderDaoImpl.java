package com.liao.dao.impl;

import java.util.List;

import com.liao.dao.OrderDao;
import com.liao.entity.Order;
import com.liao.entity.User;
import com.liao.mapper.impl.AddressMapper;
import com.liao.mapper.impl.OrderMapper;
import com.liao.mapper.impl.UserMapper;
import com.liao.util.JDBCTemplate;

@SuppressWarnings("all")
public class OrderDaoImpl implements OrderDao {
    /**
     * 添加
     *
     * @param user
     * @return
     */
    @Override
    public int addOrder(Order order) {
    	int count = 0;
        String sql = "insert orders (userid,goodsid,numbering,pric,quantity,totalPric,address,createTime,situation)values" +
                "(?,?,?,?,?,?,?,now(),?)";
        count = JDBCTemplate.executeUpdate(sql, null,
        		order.getUserID(),
        		order.getGoodsId(),
        		order.getNumbering(),
        		order.getPrice(),
        		order.getQuantity(),
        		order.getTotalPric(),
        		order.getUseraddress(),
        		order.getStatus());
//		获取数据库操作对象
//		返回数据库操作结果
        return count;
    }

    /**
     * 删除
     *
     * @param user
     * @return
     */
    @Override
    public int deleOrder(Order order) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 确认收货
     *
     * @param user
     * @return
     */
    @Override
    public int modiOrder(Order order) {
    	int count = 0;
        String sql = "update orders set situation = '已收货' where id = ?";
        count = JDBCTemplate.executeUpdate(sql, new UserMapper(),
        		order.getId());
        return count;
    }

    /**
     * 查询所有
     */
    @Override
    public int selectOrderAll() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 分页查询
     *
     * @return
     */
    @Override
    public List<Order> selectOrderByLimit(int pageNum, int pageSize, Order order, User user) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" o.id,o.userid,o.numbering,u.nikeName,g.productName ,o.goodsid");
        buffer.append(" ,o.pric,o.quantity,o.totalPric,o.situation,o.createTime ");
        buffer.append(" from orders o ");
        buffer.append(" inner join user u ");
        buffer.append(" on o.userid = u.id ");
        buffer.append(" inner join goods g ");
        buffer.append(" on o.goodsid = g.id ");
        if (user == null) {
            buffer.append(" where 1 = 1 ");
        } else {
            buffer.append(" where o.userid = " + user.getId());
        }

        if (order != null) {
//			根据用户ID
            if (order.getUserID() != null && order.getUserID().trim().length() > 0) {
                buffer.append(" and o.id = '" + order.getUserID() + "'");
            }

//			根据订单编号
            if (order.getNumbering() != null && order.getNumbering().trim().length() > 0) {
                buffer.append(" and o.numbering = '" + order.getNumbering() + "'");
            }
//			根据姓名
            if (order.getUserName() != null && order.getUserName().trim().length() > 0) {
                buffer.append(" and u.nikeName = '" + order.getUserName() + "'");
            }
//			根据地址
            if (order.getUseraddress() != null && order.getUseraddress().trim().length() > 0) {
                buffer.append(" and a.useraddress like '%" + order.getUseraddress() + "%'");
            }

//			根据商品名称
            if (order.getGoodsName() != null && order.getGoodsName().trim().length() > 0) {
                buffer.append(" and g.productName like '%" + order.getGoodsName() + "%'");
            }

//			根据价格
            if (order.getPrice() != null && order.getPrice().trim().length() > 0) {
                buffer.append(" and  g.price = '" + order.getPrice() + "'");
            }

//			根据数量
            if (order.getQuantity() != null && order.getQuantity().trim().length() > 0) {
                buffer.append(" and  o.quantity = '" + order.getQuantity() + "'");
            }

//			根据寄件人
            if (order.getStore() != null && order.getStore().trim().length() > 0) {
                buffer.append(" and  g.store = '" + order.getStore() + "'");
            }

//			根据电话
            if (order.getPhone() != null && order.getPhone().trim().length() > 0) {
                buffer.append(" and  a.phone = '" + order.getPhone() + "'");
            }
//			根据备注
            if (order.getRemarks() != null && order.getRemarks().trim().length() > 0) {
                buffer.append(" and  a.Remarks like '%" + order.getRemarks() + "%'");
            }

        }
//		buffer.append(" group by o.numbering ");
        buffer.append(" LIMIT " + pageSize * (pageNum - 1) + " , " + pageSize);
        String sql = buffer.toString();
        System.out.println("SQL:" + sql);
        List<Order> orderList = JDBCTemplate.executeQUery(sql, new OrderMapper(), null);
        return orderList;

    }

    /**
     * 根据条件查询数据条数
     *
     * @param
     * @return
     */
    @Override
    public List<Order> selectOrderouny(Order order, User user) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" o.id,o.userid,o.numbering,u.nikeName,g.productName ,o.goodsid");
        buffer.append(" ,o.pric,o.quantity,o.totalPric,o.situation,o.createTime ");
        buffer.append(" from orders o ");
        buffer.append(" inner join user u ");
        buffer.append(" on o.userid = u.id ");
        buffer.append(" inner join goods g ");
        buffer.append(" on o.goodsid = g.id ");
        if (user == null) {
            buffer.append(" where 1 = 1 ");
        } else {
            buffer.append(" where o.userid = " + user.getId());
        }
        if (order != null) {
//			根据订单编号
            if (order.getNumbering() != null && order.getNumbering().trim().length() > 0) {
                buffer.append(" and o.numbering = '" + order.getNumbering() + "'");
            }
//			根据姓名
            if (order.getUserName() != null && order.getUserName().trim().length() > 0) {
                buffer.append(" and u.nikeName = '" + order.getUserName() + "'");
            }
//			根据地址
            if (order.getUseraddress() != null && order.getUseraddress().trim().length() > 0) {
                buffer.append(" and a.useraddress like '%" + order.getUseraddress() + "%'");
            }

//			根据商品名称
            if (order.getGoodsName() != null && order.getGoodsName().trim().length() > 0) {
                buffer.append(" and g.productName like '%" + order.getGoodsName() + "%'");
            }

//			根据价格
            if (order.getPrice() != null && order.getPrice().trim().length() > 0) {
                buffer.append(" and  g.price = '" + order.getPrice() + "'");
            }

//			根据数量
            if (order.getQuantity() != null && order.getQuantity().trim().length() > 0) {
                buffer.append(" and  o.quantity = '" + order.getQuantity() + "'");
            }

//			根据寄件人
            if (order.getStore() != null && order.getStore().trim().length() > 0) {
                buffer.append(" and  g.store = '" + order.getStore() + "'");
            }

//			根据电话
            if (order.getPhone() != null && order.getPhone().trim().length() > 0) {
                buffer.append(" and  a.phone = '" + order.getPhone() + "'");
            }
//			根据备注
            if (order.getRemarks() != null && order.getRemarks().trim().length() > 0) {
                buffer.append(" and  a.Remarks like '%" + order.getRemarks() + "%'");
            }

        }
//		buffer.append(" group by o.numbering ");
        String sql = buffer.toString();

        List<Order> addressesList = JDBCTemplate.executeQUery(sql, new OrderMapper(), null);
        return addressesList;
    }
    
     
    /** 
     * 根据用户ID查询所有订单
     */
	@Override
	public List<Order> selectUserAllOrderou(Order order, User user) {
		StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" o.id,o.userid,o.numbering,u.nikeName,g.productName ,o.goodsid");
        buffer.append(" ,o.pric,o.quantity,o.totalPric,o.situation,o.createTime ");
        buffer.append(" from orders o ");
        buffer.append(" inner join user u ");
        buffer.append(" on o.userid = u.id ");
        buffer.append(" inner join goods g ");
        buffer.append(" on o.goodsid = g.id ");
        buffer.append(" where o.userid = " + user.getId());
        if(order != null){
        	buffer.append(" and o.situation = "+"'"+ order.getStatus() +"'");
        }
               
        String sql = buffer.toString();

        List<Order> addressesList = JDBCTemplate.executeQUery(sql, new OrderMapper(), null);
        return addressesList;
	}

}
