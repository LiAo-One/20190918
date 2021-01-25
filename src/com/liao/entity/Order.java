package com.liao.entity;

/**
 * 订单表
 *
 * @author soft01
 */
public class Order {
    //	订单id
    String id;
    //	用户id
    String userID;
    //	用户名称
    String userName;
    //	商品ID
    String goodsId;
    //	商品名称
    String goodsName;
    //	商品图片
    String goodsImg;
    //	单价
    String price;
    //	数量
    String quantity;
    //	总价
    String totalPric;
    //	订单编号
    String numbering;
    //	状态
    String status;
    //	时间
    String times;
    //	发货人
    String store;
    //	地址
    String useraddress;
    //	电话
    String phone;
    //	备注
    String remarks;

    public Order() {
        super();
    }

    public Order(String id, String userID, String goodsId, String goodsImg,
                 String numbering, String userName, String goodsName, String store,
                 String price, String quantity, String totalPric,
                 String useraddress, String phone, String remarks, String status,
                 String times) {
        super();
        this.id = id;
        this.userID = userID;
        this.goodsId = goodsId;
        this.goodsImg = goodsImg;
        this.numbering = numbering;
        this.userName = userName;
        this.goodsName = goodsName;
        this.store = store;
        this.price = price;
        this.quantity = quantity;
        this.totalPric = totalPric;
        this.useraddress = useraddress;
        this.phone = phone;
        this.remarks = remarks;
        this.status = status;
        this.times = times;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNumbering() {
        return numbering;
    }

    public void setNumbering(String numbering) {
        this.numbering = numbering;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getTotalPric() {
        return totalPric;
    }

    public void setTotalPric(String totalPric) {
        this.totalPric = totalPric;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", userID=" + userID + ", goodsId="
                + goodsId + ", goodsImg=" + goodsImg + ", numbering="
                + numbering + ", userName=" + userName + ", goodsName="
                + goodsName + ", store=" + store + ", price=" + price
                + ", quantity=" + quantity + ", totalPric=" + totalPric
                + ", useraddress=" + useraddress + ", phone=" + phone
                + ", remarks=" + remarks + ", status=" + status + ", times="
                + times + "]";
    }


}
