package com.liao.service;


import com.liao.entity.Goods;
import com.liao.entity.GoodsImg;
import com.liao.util.ResJson;
@SuppressWarnings("all")
public interface GoodsImgService {
	
	/**
	 * 根据商品ID查询
	 * @param goods
	 * @return
	 */
	public ResJson selectGoodsImg(Goods goods);
	
	/**
	 * 添加
	 * @param
	 * @return
	 */
	
	public ResJson addGoodsImg(GoodsImg goodsImg);
	
	
	
	/**
	 * 图片删除
	 * @param goodsImg
	 * @return
	 */
	public ResJson deleteGoodsImg(GoodsImg goodsImg);
}
