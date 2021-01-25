package com.liao.service.impl;

import java.util.List;

import com.liao.dao.GoodsImgDao;
import com.liao.entity.Goods;
import com.liao.entity.GoodsImg;
import com.liao.exception.AddBookExcoption;
import com.liao.exception.DeleExcoption;
import com.liao.factory.ObjectFactory;
import com.liao.service.GoodsImgService;
import com.liao.util.ResJson;

public class GoodsImgServiceImpl implements GoodsImgService {
    private GoodsImgDao goodsImgDao = (GoodsImgDao) ObjectFactory.getBean("GoodsImgDao");

    /**
     * 根据商品ID查询
     */
    @Override
    public ResJson selectGoodsImg(Goods goods) {
        ResJson rejs = new ResJson();
        // 判断分页参数是否合法
        try {
            // 获取查询的结果集
            List<GoodsImg> goodsList = goodsImgDao.selectGoodsImg(goods);
            // 成功
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(goodsList);
        } catch (Exception e) {
            // 异常
            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }

        // 返回结果
        return rejs;
    }

    @Override
    public ResJson addGoodsImg(GoodsImg goodsImg) {

        ResJson resj = new ResJson();
        int count = 0;
        try {
            // 判断添加参数是否为空
            if (goodsImg == null) {
                throw new AddBookExcoption("添加异常： 添加的数据为空");
            }

            if (goodsImg.getGoodsId() == null || goodsImg.getGoodsId().length() == 0) {
                throw new AddBookExcoption("添加异常： 类别ID为空");
            }

            if (goodsImg.getName() == null || goodsImg.getName().length() == 0) {
                throw new AddBookExcoption("添加异常： 类别名称为空");
            }

            // 执行添加
            count = goodsImgDao.addGoodsImg(goodsImg);
            // 判断添加是否成功
            if (count > 0) {
                resj.setSub(true);
                resj.setStr("添加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resj.setSub(false);
            resj.setStr(e.getMessage());
        }
        return resj;
    }

    /**
     * 图片删除
     */
    @Override
    public ResJson deleteGoodsImg(GoodsImg goodsImg) {
        ResJson json = new ResJson();
        // 存储删除的结果
        int count = 0;
        try {
            // 判断参数是否为空
            if (goodsImg == null) {
                throw new DeleExcoption("删除异常：数据为空");
            }

            if (goodsImg.getGoodsId() == null || goodsImg.getGoodsId().trim().length() == 0) {
                throw new DeleExcoption("删除异常：删除的id为空");
            }
            // 执行删除
            count = goodsImgDao.deleteGoodsImg(goodsImg);
            // 判断结果
            if (count > 0) {
                // 成功
                json.setSub(true);
                json.setStr("成功");
            } else {
                // 失败
                json.setSub(false);
                json.setStr("失败");
            }

        } catch (Exception e) {
            // 异常
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
        }
        // 返回结果
        return json;
    }

}
