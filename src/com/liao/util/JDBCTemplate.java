package com.liao.util;

import com.liao.mapper.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class JDBCTemplate {


    /**
     * 将增删改封装成一个方法
     *
     * @param sql   操作语句
     * @param param
     * @return 返回操作结果
     */
    public static int executeUpdate(String sql, RowMapper rowMapper, Object... param) {

        int count = 0;

        Connection conn = null;

        PreparedStatement ptmt = null;
        try {
            try {
//				获取数据库链接对象
                conn = JDBCUtil.getConn();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ptmt = conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                ptmt.setObject(i + 1, param[i]);
            }

            count = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//		返回数据库操作结果
        return count;
    }

    /**
     * 查询封装成一个方法
     *
     * @param sql
     * @return
     */
    public static List executeQUery(String sql, RowMapper rowMapper, Object... param) {
//		存储查询到的数据集合
        List list = new ArrayList();
//		获取数据库链接对象
        Connection conn = null;
//		获取操作对象
        PreparedStatement ptmt = null;
//		执行操作对象
        ResultSet rs = null;
//		调用方法获取连接对象
        conn = JDBCUtil.getConn();

        try {
            ptmt = conn.prepareStatement(sql);
//			判断是否有参数
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    ptmt.setObject(i + 1, param[i]);
                }
            }
//			获取查询到的数据
            rs = ptmt.executeQuery();
//			循环取出查询到的数据，并赋值给list
            while (rs.next()) {
                Object o = rowMapper.objectMapper(rs);
                list.add(o);
            }


        } catch (SQLException e) {
            e.printStackTrace();
//			关闭资源
        }

        return list;
    }
}
