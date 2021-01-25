package com.liao.entity;

public class Goods {
    //	商品id；
    private String id;
    //	商品名称
    private String productName;
    //	类别id
    private String idcode;
    //	详情
//	private String details;
//	价格
    private String price;
    //	销量
    private String salesVolume;
    //	库存
    private String inStock;
    //	厂家
    private String factory;
    //	店家;
    private String store;
    ////	属性
//	private String attributes;
//	保质期
    private String shelflife;
    //	状态
    private String situation;
    //	创建时间
    private String createTime;
    //	折扣
    private String Discount;
    //	是否包邮
    private String post;
    //	商品图片
    private String img;
    //	商品类别
    private String typeName;

    //	提供无参方法
    public Goods() {
        super();
    }

    //	提供有参方法
    public Goods(String id, String productName, String idcode, String price, String salesVolume, String inStock, String factory, String store, String shelflife, String situation, String createTime,
                 String discount, String post, String img, String typeName) {
        super();
        this.id = id;
        this.productName = productName;
        this.idcode = idcode;
        this.price = price;
        this.salesVolume = salesVolume;
        this.inStock = inStock;
        this.factory = factory;
        this.store = store;
        this.shelflife = shelflife;
        this.situation = situation;
        this.createTime = createTime;
        this.Discount = discount;
        this.post = post;
        this.img = img;
        this.typeName = typeName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(String salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getShelflife() {
        return shelflife;
    }

    public void setShelflife(String shelflife) {
        this.shelflife = shelflife;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Goods [Discount=" + Discount + ", createTime=" + createTime + ", factory=" + factory + ", id=" + id + ", idcode=" + idcode + ", img=" + img + ", inStock=" + inStock + ", post=" + post
                + ", price=" + price + ", productName=" + productName + ", salesVolume=" + salesVolume + ", shelflife=" + shelflife + ", situation=" + situation + ", store=" + store + ", typeName="
                + typeName + "]";
    }


}
