package com.liao.dao.impl;

import java.util.List;

import com.liao.dao.GoodsImgDao;
import com.liao.entity.Goods;
import com.liao.entity.GoodsImg;
import com.liao.mapper.impl.CategoryMapper;
import com.liao.mapper.impl.GoodsImgMapper;
import com.liao.util.JDBCTemplate;

@SuppressWarnings("all")
public class GoodsImgDaoImpl implements GoodsImgDao {

    /**
     * 根据商品ID查询图片
     */
    @Override
    public List<GoodsImg> selectGoodsImg(Goods goods) {
        String sql = "select id,goodsid,name,creatime from goodsimg where goodsid = ?";

        List<GoodsImg> imgList = JDBCTemplate.executeQUery(sql, new GoodsImgMapper(), goods.getId());

        return imgList;
    }

    /**
     * 商品图片添加
     */
    @Override
    public int addGoodsImg(GoodsImg goodsImg) {
        String sql = "insert goodsimg (goodsid,name,creatime)values(?,?,now())";
        int count = JDBCTemplate.executeUpdate(sql, null,
                goodsImg.getGoodsId(),
                goodsImg.getName());
//		返回操作结果

        return count;
    }

    /**
     * 商品删除
     */
    @Override
    public int deleteGoodsImg(GoodsImg goodsImg) {
        String sql = "delete from goodsimg where goodsid = ?";

        int coun = JDBCTemplate.executeUpdate(sql, null, goodsImg.getGoodsId());
        return coun;
    }

    /**
     * 根据商品ID查询图片
     * @param goods
     * @return
     */
    @Override
    public List<GoodsImg> showGoodsImg(Goods goods) {

        return null;
    }

}
