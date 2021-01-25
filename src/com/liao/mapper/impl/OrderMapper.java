package com.liao.mapper.impl;

import java.sql.ResultSet;

import com.liao.entity.Order;
import com.liao.mapper.RowMapper;

/**
 * 订单
 * 将结果集转换为对象
 *
 * @author soft01
 */
public class OrderMapper implements RowMapper {

    @Override
    public Object objectMapper(ResultSet rs) {
        Order o = null;
        try {
            o = new Order();
//			订单ID
            o.setId(rs.getString("o.id"));
//			用户ID
            o.setUserID(rs.getString("o.userid"));
//			用户名称
            o.setUserName(rs.getString("u.nikeName"));
//			商品ID
            o.setGoodsId(rs.getString("o.goodsid"));
//			商品名称
            o.setGoodsName(rs.getString("g.productName"));
//			商品图片
//			o.setGoodsImg(rs.getString("asd"));
//			单价
            o.setPrice(rs.getString("o.pric"));
//			数量
            o.setQuantity(rs.getString("o.quantity"));
//			总价
            o.setTotalPric(rs.getString("o.totalPric"));
//			订单编号
            o.setNumbering(rs.getString("o.numbering"));
//			状态
            o.setStatus(rs.getString("o.situation"));
//			时间
            o.setTimes(rs.getString("o.createTime"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

}









