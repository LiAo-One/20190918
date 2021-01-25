package com.liao.service;


import com.liao.entity.Goods;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public interface GoodsService {
    /**
     * 添加
     *
     * @param goods
     * @return
     */
    public ResJson addGoods(Goods goods);

    /**
     * 删除
     *
     * @param goods
     * @return
     */
    public ResJson deleGoods(Goods goods);

    /**
     * 修改
     *
     * @param goods
     * @return
     */
    public ResJson modiGoods(Goods goods);

    /**
     * 模糊查询
     *
     * @param
     * @return
     */
    public void showGoods(Goods goods);

    /**
     * 查询所有
     */
    public ResJson selectGoodsAll();

    /**
     * 分页查询
     *
     * @return
     */
    public ResJson selectGoodsByLimit(int pageNum, int pageSize, Goods goods);


    /**
     * 按照条件查询数量
     *
     * @param goods
     * @return
     */
    public int selectGoodsCouny(Goods goods);

    /**
     * 上传数据
     *
     * @return
     */
    public ResJson importGoods();

    /**
     * 下载数据
     *
     * @return
     */
    public ResJson download(Goods goods);


    /**
     * 查询最后一条商品
     *
     * @return
     */
    public ResJson selectGoodsAtLast();
}
