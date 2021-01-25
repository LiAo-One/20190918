package com.liao.mapper.impl;

import java.sql.ResultSet;

import com.liao.entity.Goods;
import com.liao.mapper.RowMapper;

/**
 * 商品
 * 将结果集转换为对象
 *
 * @author soft01
 */
public class GoodsMapper implements RowMapper {

    @Override
    public Object objectMapper(ResultSet rs) {
        Goods goods = null;
        try {
            goods = new Goods();
//			id
            goods.setId(rs.getString("g.id"));
//			名称
            goods.setProductName(rs.getString("g.productName"));
//			类别id
            goods.setIdcode(rs.getString("g.idcode"));
//			价格
            goods.setPrice(rs.getString("g.price"));
//			销量
            goods.setSalesVolume(rs.getString("g.salesVolume"));
//			库存
            goods.setInStock(rs.getString("g.inStock"));
//			厂家
            goods.setFactory(rs.getString("g.factory"));
//			店家
            goods.setStore(rs.getString("g.store"));
//			保质期
            goods.setShelflife(rs.getString("g.shelflife"));
//			图片
            goods.setImg(rs.getString("g.img"));
//			邮递
            goods.setPost(rs.getString("g.post"));
//			折扣
            goods.setDiscount(rs.getString("g.discount"));
//			状态
            goods.setSituation(rs.getString("g.situation"));
//			时间
            goods.setCreateTime(rs.getString("g.createTime"));
//			类别名称
            goods.setTypeName(rs.getString("c.category"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    }


}
