package com.liao.entity;

/**
 * 购物车类
 *
 * @author soft01
 */
public class ShoppingCart {
    //	购物车id
    String id;
    //	用户ID；
    String userId;
    //	用户姓名
    String userName;
    //	商品ID；
    String goodsId;
    //	商品名称
    String goodsName;
    //	图片
    String img;
    //	价格
    String price;
    //	数量
    String quantity;
    //	总价
    String totalPrice;
    //	状态
    String situation;
    //	时间
    String times;

    public ShoppingCart() {
        super();
    }


    public ShoppingCart(String id, String userId, String userName, String goodsId, String goodsName, String img, String price, String quantity, String totalPrice, String situation, String times) {
        super();
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.situation = situation;
        this.times = times;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    //单价
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //数量
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    //总价
    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }


    public String getSituation() {
        return situation;
    }


    public void setSituation(String situation) {
        this.situation = situation;
    }


    @Override
    public String toString() {
        return "ShoppingCart [goodsId=" + goodsId + ", goodsName=" + goodsName + ", id=" + id + ", img=" + img + ", price=" + price + ", quantity=" + quantity + ", situation=" + situation
                + ", times=" + times + ", totalPrice=" + totalPrice + ", userId=" + userId + ", userName=" + userName + "]";
    }


}


















