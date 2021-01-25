package com.liao.entity;

public class Category {
    //	类别id；
    private String id;
    //	类别名称
    private String category;
    //	时间
    private String createTime;

    //	提供无参方法
    public Category() {
        super();
    }
//	提供有参方法

    public Category(String id, String category, String createTime) {
        super();
        this.id = id;
        this.category = category;
        this.createTime = createTime;
    }

    //	get和set方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "Category [category=" + category + ", createTime=" + createTime + ", id=" + id + "]";
    }


}
