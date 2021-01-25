package com.liao.mapper.impl;

import java.sql.ResultSet;

import com.liao.entity.Address;
import com.liao.mapper.RowMapper;

/**
 * 地址
 * 将结果集转换为对象
 *
 * @author soft01
 */
public class AddressMapper implements RowMapper {

    @Override
    public Object objectMapper(ResultSet rs) {
        Address a = null;
        try {
            a = new Address();
            a.setId(rs.getString("a.id"));
            a.setUserid(rs.getString("a.userid"));
            a.setName(rs.getString("a.name"));
            a.setUseraddress(rs.getString("a.useraddress"));
            a.setPhone(rs.getString("a.phone"));
            a.setRemarks(rs.getString("a.Remarks"));
            a.setSituation(rs.getString("a.situation"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

}
