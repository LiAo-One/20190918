package com.liao.entity;

public class Comment {
    // 评论ID
    String id;
    // 所属用户ID
    String userid;
    //	用户姓名
    String userName;
    // 用户头像
    String userImg;
    // 商品id
    String goodsid;
    // 商品名称
    String goodsName;
    // 满意度
    String mood;
    // 评论语句
    String fell;
    // 状态
    String situation;
    // 时间
    String times;

    public Comment() {
        super();
    }


    public Comment(String id, String userid, String userName, String userImg, String goodsid, String goodsName, String mood, String fell, String situation, String times) {
        super();
        this.id = id;
        this.userid = userid;
        this.userName = userName;
        this.userImg = userImg;
        this.goodsid = goodsid;
        this.goodsName = goodsName;
        this.mood = mood;
        this.fell = fell;
        this.situation = situation;
        this.times = times;
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

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getFell() {
        return fell;
    }

    public void setFell(String fell) {
        this.fell = fell;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Comment [fell=" + fell + ", goodsName=" + goodsName + ", goodsid=" + goodsid + ", id=" + id + ", mood=" + mood + ", situation=" + situation + ", times=" + times + ", userImg="
                + userImg + ", userName=" + userName + ", userid=" + userid + "]";
    }


}
