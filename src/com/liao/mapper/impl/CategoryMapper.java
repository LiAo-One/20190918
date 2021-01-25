package com.liao.mapper.impl;

import java.sql.ResultSet;

import com.liao.entity.Category;
import com.liao.mapper.RowMapper;

/**
 * 商品类别
 * 将结果集转换为对象
 *
 * @author soft01
 */
public class CategoryMapper implements RowMapper {

    @Override
    public Object objectMapper(ResultSet rs) {

        Category category = null;

        try {
            category = new Category();

            category.setId(rs.getString("id"));
            category.setCategory(rs.getString("category"));
            category.setCreateTime(rs.getString("createTime"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return category;
    }

}
