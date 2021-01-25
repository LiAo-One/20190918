package com.liao.util;

import java.util.List;

@SuppressWarnings("all")
public class ResJson {
    //	登录结果
    private boolean sub;
    //	登录信息
    private String str;
    //	登陆返回的集合
    private List list;

    public ResJson() {
        super();
    }

    public ResJson(boolean sub, String str, List list) {
        super();
        this.sub = sub;
        this.str = str;
        this.list = list;
    }

    public boolean getSub() {
        return sub;
    }

    public void setSub(boolean sub) {
        this.sub = sub;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }


}
