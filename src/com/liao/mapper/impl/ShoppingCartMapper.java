package com.liao.mapper.impl;

import java.sql.ResultSet;

import com.liao.entity.ShoppingCart;
import com.liao.mapper.RowMapper;

/**
 * 购物车
 * 将结果集转换为对象
 *
 * @author soft01
 */
public class ShoppingCartMapper implements RowMapper {

    @Override
    public Object objectMapper(ResultSet rs) {
        ShoppingCart shoppingCart = new ShoppingCart();
        try {
//			购物车ID
            shoppingCart.setId(rs.getString("s.id"));
//			所属用户ID
            shoppingCart.setUserId(rs.getString("s.userid"));
//			用户姓名
            shoppingCart.setUserName(rs.getString("u.nikeName"));
//			商品ID
            shoppingCart.setGoodsId(rs.getString("g.id"));
//			商品名称
            shoppingCart.setGoodsName(rs.getString("g.productName"));
//			商品图片
            shoppingCart.setImg(rs.getString("s.img"));
//			商品价格
            shoppingCart.setPrice(rs.getString("s.pric"));
//			数量
            shoppingCart.setQuantity(rs.getString("s.quantity"));
//			小计
            shoppingCart.setTotalPrice(rs.getString("s.totalPric"));
//			状态
            shoppingCart.setSituation(rs.getString("s.situation"));
//			购物车创建时间
            shoppingCart.setTimes(rs.getString("s.creatime"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoppingCart;
    }

}
