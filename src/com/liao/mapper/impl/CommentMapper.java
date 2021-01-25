package com.liao.mapper.impl;

import java.sql.ResultSet;

import com.liao.entity.Comment;
import com.liao.mapper.RowMapper;

public class CommentMapper implements RowMapper {

    @Override
    public Object objectMapper(ResultSet rs) {
        Comment c = null;
        try {
            c = new Comment();
            c.setId(rs.getString("c.id"));
            c.setUserid(rs.getString("c.userid"));
            c.setUserName(rs.getString("u.nikeName"));
            c.setUserImg(rs.getString("u.img"));
            c.setGoodsid(rs.getString("c.goodsid"));
            c.setGoodsName(rs.getString("g.productName"));
            c.setMood(rs.getString("c.mood"));
            c.setFell(rs.getString("c.feel"));
            c.setSituation(rs.getString("c.situation"));
            c.setTimes(rs.getString("c.creatime"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

}
