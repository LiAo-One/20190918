package com.liao.dao;

import java.util.List;

import com.liao.entity.Goods;

public interface GoodsDao {
	
	/**
	 * 添加
	 * @param goods
	 * @return
	 */
	public int addGoods(Goods goods);
	/**
	 * 删除
	 * @param goods
	 * @return
	 */
	public int deleGoods(Goods goods);
	/**
	 * 修改
	 * @param goods
	 * @return
	 */
	public int modiGoods(Goods goods);
	/**
	 * 模糊查询
	 * @param
	 * @return
	 */
	public void showGoods(Goods goods);
	/**
	 * 查询所有
	 */
	public List<Goods> selectGoodsAll();
	
	/**
	 * 分页查询
	 * @return
	 */
	public List<Goods> selectGoodsByLimit(int pageNum , int pageSize,Goods goods);
	
	/**
	 * 根据条件查询数据条数
	 * @param goods
	 * @return
	 */
	public List<Goods> selectGoodsCouny(Goods goods);
	/**
	 * 导出文件
	 * @param goods
	 * @return
	 */
	public List<Goods> download(Goods goods);
	
	/**
	 * 根据商品ID查询最后一条数据
	 * @return
	 */
	public List<Goods> selectGoodsAtLast();
	
	
	
}
