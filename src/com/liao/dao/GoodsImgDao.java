package com.liao.dao;

import java.util.List;

import com.liao.entity.Goods;
import com.liao.entity.GoodsImg;

public interface GoodsImgDao {


    /**
     * 根据条件查询数据条数
     *
     * @param goods
     * @return
     */
    public List<GoodsImg> selectGoodsImg(Goods goods);

    /**
     * 添加
     *
     * @param
     * @return
     */

    public int addGoodsImg(GoodsImg goodsImg);

    /**
     * 商品图片删除
     *
     * @param goodsImg
     * @return
     */
    public int deleteGoodsImg(GoodsImg goodsImg);


    /**
     * g根据商品ID查询图片
     * @param goods
     * @return
     */
    public List<GoodsImg> showGoodsImg(Goods goods);
}
