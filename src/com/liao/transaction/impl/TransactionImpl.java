package com.liao.transaction.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.liao.transaction.Transaction;
import com.liao.util.JDBCUtil;

public class TransactionImpl implements Transaction {
    //	开启事物
    @Override
    public void begin() {
        Connection conn = JDBCUtil.getConn();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //	事物回滚
    @Override
    public void commit() {
        Connection conn = JDBCUtil.getConn();
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //	事物提交
    @Override
    public void rollback() {
        Connection conn = JDBCUtil.getConn();
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
