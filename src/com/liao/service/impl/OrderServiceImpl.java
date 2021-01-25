package com.liao.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.dao.OrderDao;
import com.liao.entity.Order;
import com.liao.entity.User;
import com.liao.exception.AddBookExcoption;
import com.liao.exception.ModiExcoption;
import com.liao.exception.ShowIDExcoption;
import com.liao.factory.ObjectFactory;
import com.liao.service.OrderService;
import com.liao.util.ResJson;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = (OrderDao) ObjectFactory.getBean("OrderDao");

    /**
     * 添加
     *
     * @param user
     * @return
     */
    @Override
    public ResJson addOrder(Order order) {
    	ResJson json = new ResJson();
        int count = 0;
        try {
//			判断添加参数是否为空
            if (order == null) {
                throw new AddBookExcoption("添加的数据为空");
            }
//			判断添加帐号是否唯空
            if (order.getUserID() == null || order.getUserID().trim().length() == 0) {
                throw new AddBookExcoption("用户不存在");
            }
//			判断添加密码是否唯空
            if (order.getGoodsId() == null || order.getGoodsId().trim().length() == 0) {
                throw new AddBookExcoption("商品不存在");
            }

//			判断姓名是否为空
            if (order.getNumbering() == null || order.getNumbering().trim().length() < 0) {
				throw new AddBookExcoption("无法生成订单编号");
            }
            
//			判断姓名是否为空
            if (!(order.getNumbering().trim().length() == 8)) {
				throw new AddBookExcoption("订单编号开小差了");
            }
//			判断年龄是否为空
            if (order.getPrice() == null || order.getPrice().trim().length() < 0) {
				throw new AddBookExcoption("商品开小差了");
            }
            
//			判断年龄是否为空
            if (order.getQuantity() == null || order.getQuantity().trim().length() < 0) {
            	order.setQuantity("1");
            }
            
//			判断年龄是否为空
            if (order.getTotalPric() == null || order.getTotalPric().trim().length() < 0) {
            	throw new AddBookExcoption("总价格不存在");
            }
            
//			判断年龄是否为空
            if (order.getUseraddress() == null || order.getUseraddress().trim().length() < 0) {
            	throw new AddBookExcoption("请选择地址");
            }
            
//			判断年龄是否为空
            if (order.getStatus() == null || order.getStatus().trim().length() < 0) {
            	order.setStatus("待付款");
            }

//			执行添加
            count = orderDao.addOrder(order);
//			判断添加是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("下单成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            json.setSub(false);
            json.setList(null);
            json.setStr(e.getMessage());
        }
        return json;
    }

    /**
     * 删除
     *
     * @param order
     * @return
     */
    @Override
    public ResJson deleOrder(Order order) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 修改
     *
     * @param order
     * @return
     */
    @Override
    public ResJson modiOrder(Order order) {
    	ResJson json = new ResJson();
        int count = 0;
        try {
//			判断修改的参数是否为空
            if (order == null) {
                throw new ModiExcoption("修改异常： 添加修改的数据为空");
            }
//			判断帐号是否唯空
            if (order.getId() == null || order.getId().trim().length() == 0) {
                throw new AddBookExcoption("订单丢失");
            }
//			执行修改
            count = orderDao.modiOrder(order);
//			判断修改是否成功
            if (count > 0) {
                json.setSub(true);
                json.setStr("成功");
            } else {
                json.setSub(false);
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
     * 查询所有
     */
    @Override
    public ResJson selectOrderAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 分页查询
     *
     * @return
     */
    @Override
    public ResJson selectOrderByLimit(int pageNum, int pageSize, Order order, User user) {
        ResJson rejs = new ResJson();
//		判断分页数据是否合法
        try {
            if (pageNum < 1) {
                throw new ShowIDExcoption("pageNum不合法");
            }
            if (pageSize < 1) {
                throw new ShowIDExcoption("pageSize不合法");
            }
//			获取查询到的集合
            List<Order> orderList = orderDao.selectOrderByLimit(pageNum, pageSize, order, user);
//			成功
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(orderList);
        } catch (Exception e) {
//			异常
            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }
//		返回结果
        return rejs;
    }

    /**
     * 根据条件查询数据条数
     *
     * @param
     * @return
     */
    @Override
    public int selectOrderouny(Order order, User user) {
        int count = 0;
//		获取返回的集合
        List<Order> orderList = orderDao.selectOrderouny(order, user);
        count = orderList.size();
//		返回结果
        return count;
    }

    
    /**
     * 根据用户查询有所订单
     */
	@Override
	public ResJson selectUserAllOrderou(Order order, User user) {
		
		 ResJson rejs = new ResJson();
		 
		 List<Order> orderList = null;
//			判断分页数据是否合法
	        try {
	            if (user == null) {
	                throw new ShowIDExcoption("用户ID不存在不合法");
	            }
//				获取查询到的集合
	            if(order.getStatus().equals("全部") ){
	            	orderList = orderDao.selectUserAllOrderou(null, user);
	            }else{
	            	orderList = orderDao.selectUserAllOrderou(order, user);
	            }
	            
//				成功
	            rejs.setSub(true);
	            rejs.setStr("查询成功");
	            rejs.setList(orderList);
	        } catch (Exception e) {
//				异常
	            rejs.setSub(false);
	            rejs.setStr(e.getMessage());
	            rejs.setList(null);
	        }
//			返回结果
	        return rejs;
	}
	
	

}
