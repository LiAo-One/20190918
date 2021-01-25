package com.liao.entity;

public class Address {
    //	地址id
    String id;
    //	所属用户id
    String userid;
    //	收件人姓名
    String name;
    //	地址
    String useraddress;
    //	联系方式
    String phone;
    //	状态
    String situation;
    //	备注
    String remarks;

    public Address() {
        super();
    }

    public Address(String id, String userid, String name, String useraddress,
                   String phone, String situation, String remarks) {
        super();
        this.id = id;
        this.userid = userid;
        this.name = name;
        this.useraddress = useraddress;
        this.phone = phone;
        this.situation = situation;
        this.remarks = remarks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", userid=" + userid + ", name=" + name
                + ", useraddress=" + useraddress + ", phone=" + phone
                + ", situation=" + situation + ", remarks=" + remarks + "]";
    }


}
