package com.liao.transaction;

public interface Transaction {
    //	开启事物
    public void begin();

    //	回滚
    public void rollback();

    //	提交
    public void commit();
}
