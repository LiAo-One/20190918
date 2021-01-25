package com.liao.mapper.impl;

import java.sql.ResultSet;

import com.liao.entity.User;
import com.liao.mapper.RowMapper;

/**
 * 用户
 * 将结果集转换为对象
 *
 * @author soft01
 */
public class UserMapper implements RowMapper {

    @Override
    public Object objectMapper(ResultSet rs) {
        User u = null;
        try {
            u = new User();
            u.setId(rs.getString("id"));
            u.setNikeName(rs.getString("nikeName"));
            u.setLoginName(rs.getString("logName"));
            u.setLoginPwd(rs.getString("logPwd"));
            u.setLev(rs.getString("lev"));
            u.setSex(rs.getString("sex"));
            u.setAge(rs.getString("age"));
            u.setImg(rs.getString("img"));
            u.setCreateTime(rs.getString("createTime"));
            u.setBalance(rs.getString("balance"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }


}
