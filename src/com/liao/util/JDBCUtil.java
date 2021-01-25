package com.liao.util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class JDBCUtil {

    //	定义数据源
    private static DataSource ds = null;

    //	创建连接池
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    //	读取文件
    static {
        Properties p = new Properties();

        try {
            p.load(JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties"));


            ds = BasicDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //	获取数据库连接对象;
    public static Connection getConn() {
        Connection conn = threadLocal.get();

        if (conn == null) {
            try {
                conn = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocal.set(conn);
        }
//		返回链接对象的值
        return threadLocal.get();

    }


//	关闭数据库资源


    public static void color(ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void color(ResultSet rs, PreparedStatement ptmt) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ptmt != null) {
            try {
                ptmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void color(ResultSet rs, PreparedStatement ptmt, Connection conn) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ptmt != null) {
            try {
                ptmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}













