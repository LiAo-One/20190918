package com.liao.entity;

/**
 * 商品图片
 *
 * @author soft01
 */
public class GoodsImg {
    // id
    public String id;
    //	商品id
    public String goodsId;
    // 图片
    public String name;
    // 时间
    public String time;

    /**
     * 无参方法
     */
    public GoodsImg() {
        super();
    }

    public GoodsImg(String id, String goodsId, String name, String time) {
        super();
        this.id = id;
        this.goodsId = goodsId;
        this.name = name;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "GoodsImg [id=" + id + ", name=" + name + ", time=" + time + "]";
    }


}
