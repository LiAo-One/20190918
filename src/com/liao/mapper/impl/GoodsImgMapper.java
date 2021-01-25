package com.liao.mapper.impl;

import java.sql.ResultSet;

import com.liao.entity.GoodsImg;
import com.liao.mapper.RowMapper;

public class GoodsImgMapper implements RowMapper {

    @Override
    public Object objectMapper(ResultSet rs) {
        GoodsImg goodsImg = null;
        try {
            goodsImg = new GoodsImg();
//			id
            goodsImg.setId(rs.getString("id"));
//			名称
            goodsImg.setGoodsId(rs.getString("goodsid"));
//			类别id
            goodsImg.setName(rs.getString("name"));
//			价格
            goodsImg.setTime(rs.getString("creatime"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsImg;
    }

}
