package com.liao.dao.impl;

import java.util.List;


import com.liao.dao.GoodsDao;
import com.liao.entity.Goods;
import com.liao.mapper.impl.GoodsMapper;
import com.liao.util.JDBCTemplate;

@SuppressWarnings("all")
public class GoodsDaoImpl implements GoodsDao {

    static Goods goods = null;


    /**
     * 添加
     *
     * @param goods
     * @return
     */
    @Override
    public int addGoods(Goods goods) {
        String sql = "insert goods(idcode," +
                "productName,price,salesVolume,inStock," +
                "store,factory,shelflife,img,discount," +
                "situation,post,createTime)values" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,now())";
        int count = JDBCTemplate.executeUpdate(sql, new GoodsMapper(),
                goods.getIdcode(),
                goods.getProductName(),
                goods.getPrice(),
                goods.getSalesVolume(),
                goods.getInStock(),
                goods.getStore(),
                goods.getFactory(),
                goods.getShelflife(),
                goods.getImg(),
                goods.getDiscount(),
                goods.getSituation(),
                goods.getPost());
//		返回操作结果

        return count;
    }

    /**
     * 删除
     *
     * @param goods
     * @return
     */
    @Override
    public int deleGoods(Goods goods) {
        String sql = " update goods set situation = '下架' where id = ? ";
        int count = JDBCTemplate.executeUpdate(sql, new GoodsMapper(), goods.getId());
        return count;
    }


    /**
     * 修改
     *
     * @param goods
     * @return
     */
    @Override
    public int modiGoods(Goods goods) {
        String sql = "update goods set idcode = ?,productName = ?,price = ?,salesVolume = ?," +
                "inStock  = ?,store = ?,factory = ?,shelflife = ?,img = ?,discount = ?," +
                "situation = ?,post = ? where id = ? ";
        int count = JDBCTemplate.executeUpdate(sql, new GoodsMapper(),
                goods.getIdcode(),
                goods.getProductName(),
                goods.getPrice(),
                goods.getSalesVolume(),
                goods.getInStock(),
                goods.getStore(),
                goods.getFactory(),
                goods.getShelflife(),
                goods.getImg(),
                goods.getDiscount(),
                goods.getSituation(),
                goods.getPost(),
                goods.getId());

        return count;
    }

    /**
     * 模糊查询
     */
    @Override
    public void showGoods(Goods goods) {
//			查询语句
        String sql = "select id,productName,idcode,details,price,salesVolume,inStock,factory,store,attributes,shelflife,situation,createTime,Discount,post,img" +
                " from T_GOODS where id = ? or productName = ? or idcode = ? or details = ? or price = ? or salesVolume = ? or inStock = ? or " +
                "factory = ? or store = ? or attributes = ? or shelflife = ? or situation = ? or createTime = ? or Discount = ? or post = ? or img = ?;";
        List list = JDBCTemplate.executeQUery(sql, new GoodsMapper(),
                goods.getId(),
                goods.getProductName(),
                goods.getIdcode(),
                goods.getPrice(),
                goods.getSalesVolume(),
                goods.getInStock(),
                goods.getFactory(),
                goods.getStore(),
                goods.getShelflife(),

                goods.getSituation(),
                goods.getCreateTime(),
                goods.getDiscount(),
                goods.getPost(),
                goods.getImg());

        for (Object attribute : list) {
        }
    }

    /**
     * 查询全部
     */
    @Override
    public List<Goods> selectGoodsAll() {
//		查询语句
        String sql = "select g.id,g.productName,g.idcode,g.price,g.salesVolume," +
                "g.inStock,g.factory,g.store,g.shelflife,g.img,g.post," +
                "g.discount,g.situation,g.createTime,c.category from goods g inner " +
                "join category c " +
                "on g.idcode = c.id";
//		获取查寻到的数据
        List<Goods> goodsList = JDBCTemplate.executeQUery(sql, new GoodsMapper(), null);
//		遍历集合输出
        return goodsList;

    }

    /**
     * 查询满足条件的数据
     */
    @Override
    public List<Goods> selectGoodsByLimit(int pageNum, int pageSize, Goods goods) {
//		拼接查询语句
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" g.id,g.idcode,g.productName,g.price,g.salesVolume,g.inStock,g.store,g.factory," +
                "g.shelflife,g.img,g.discount,g.situation,g.post," +
                "g.createTime,c.id,c.category");
        buffer.append(" from goods g ");
        buffer.append(" inner join category c ");
        buffer.append(" on g.idcode = c.id ");
        buffer.append(" WHERE g.situation = '上架'");
//		判断goods有无数据
        if (goods != null) {
//			根据商品名称
            if (goods.getProductName() != null && goods.getProductName().trim().length() > 0) {
                buffer.append(" and g.productName like '%" + goods.getProductName() + "%'");
            }
//			根据价格
            if (goods.getPrice() != null && goods.getPrice().trim().length() > 0) {
                buffer.append(" and g.price = " + goods.getPrice());
            }
//			根据+库存

            if (goods.getIdcode() != null && goods.getIdcode().trim().length() > 0) {
                buffer.append(" and g.idcode = " + goods.getIdcode());
            }
//			根据销量

            if (goods.getSalesVolume() != null && goods.getSalesVolume().trim().length() > 0) {
                buffer.append(" and  g.salesVolume = " + goods.getSalesVolume());
            }
//			根据类别
            if (goods.getTypeName() != null && goods.getTypeName().trim().length() > 0) {
                buffer.append(" and c.category = '" + goods.getTypeName() + "'");
            }
//			根据店家
            if (goods.getStore() != null && goods.getStore().trim().length() > 0) {
                buffer.append(" and g.store  like '%" + goods.getStore() + "%'");
            }
//			根据保质期
            if (goods.getShelflife() != null && goods.getShelflife().trim().length() > 0) {
                buffer.append(" and g.shelflife  like '" + goods.getShelflife() + "'");
            }
//			根据邮递
            if (goods.getPost() != null && goods.getPost().trim().length() > 0) {
                buffer.append(" and g.post  = '" + goods.getPost() + "'");
            }
//			根据图片
            if (goods.getImg() != null && goods.getImg().trim().length() > 0) {
                buffer.append(" and g.img  like '%" + goods.getImg() + "%'");
            }

//			根据厂家
            if (goods.getFactory() != null && goods.getFactory().trim().length() > 0) {
                buffer.append(" and g.factory like '%" + goods.getFactory() + "%'");
            }

//			根据折扣
            if (goods.getDiscount() != null && goods.getDiscount().trim().length() > 0) {
                buffer.append(" and g.discount  = '" + goods.getDiscount() + "'");
            }

//			根据状态
            if (goods.getSituation() != null && goods.getSituation().trim().length() > 0) {
                buffer.append(" and g.situation  = '" + goods.getSituation() + "'");
            }

        }
//		分页查询
//		pageSize 每次展示数据的条数
        buffer.append(" order by g.id asc ");
        buffer.append(" LIMIT " + pageSize * (pageNum - 1) + " , " + pageSize);

        String sql = buffer.toString();
        List<Goods> goodsList = JDBCTemplate.executeQUery(sql, new GoodsMapper(), null);
        return goodsList;
    }

    /**
     * 满足条件的总数
     */
    @Override
    public List<Goods> selectGoodsCouny(Goods goods) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" g.id,g.idcode,g.productName,g.price,g.salesVolume,g.inStock,g.store,g.factory," +
                "g.shelflife,g.img,g.discount,g.situation,g.post," +
                "g.createTime,c.id,c.category");
        buffer.append(" from goods g ");
        buffer.append(" inner join category c ");
        buffer.append(" on g.idcode = c.id ");
        buffer.append(" WHERE g.situation = '上架'");

        if (goods != null) {
//			根据商品名称
            if (goods.getProductName() != null && goods.getProductName().trim().length() > 0) {
                buffer.append(" and g.productName like '%" + goods.getProductName() + "%'");
            }
//			根据价格
            if (goods.getPrice() != null && goods.getPrice().trim().length() > 0) {
                buffer.append(" and g.price = " + goods.getPrice());
            }

//			根据库存

            if (goods.getIdcode() != null && goods.getIdcode().trim().length() > 0) {
                buffer.append(" and g.idcode = " + goods.getIdcode());
            }

//			根据销量

            if (goods.getSalesVolume() != null && goods.getSalesVolume().trim().length() > 0) {
                buffer.append(" and  g.salesVolume = " + goods.getSalesVolume());
            }
//			根据类别
            if (goods.getTypeName() != null && goods.getTypeName().trim().length() > 0) {
                buffer.append(" and c.category = '" + goods.getTypeName() + "'");
            }
//			根据店家
            if (goods.getStore() != null && goods.getStore().trim().length() > 0) {
                buffer.append(" and g.store  like '%" + goods.getStore() + "%'");
            }
//			根据保质期
            if (goods.getShelflife() != null && goods.getShelflife().trim().length() > 0) {
                buffer.append(" and g.shelflife  like '" + goods.getShelflife() + "'");
            }
//			根据邮递
            if (goods.getPost() != null && goods.getPost().trim().length() > 0) {
                buffer.append(" and g.post  = '" + goods.getPost() + "'");
            }
//			根据图片
            if (goods.getImg() != null && goods.getImg().trim().length() > 0) {
                buffer.append(" and g.img  like '%" + goods.getImg() + "%'");
            }

//			根据厂家
            if (goods.getFactory() != null && goods.getFactory().trim().length() > 0) {
                buffer.append(" and g.factory like '%" + goods.getFactory() + "%'");
            }

//			根据折扣
            if (goods.getDiscount() != null && goods.getDiscount().trim().length() > 0) {
                buffer.append(" and g.discount  = '" + goods.getDiscount() + "'");
            }

//			根据状态
            if (goods.getSituation() != null && goods.getSituation().trim().length() > 0) {
                buffer.append(" and g.situation  = '" + goods.getSituation() + "'");
            }

        }

        String sql = buffer.toString();

        List<Goods> goodsList = JDBCTemplate.executeQUery(sql, new GoodsMapper(), null);
        return goodsList;
    }

    @Override
    public List<Goods> download(Goods goods) {
//		拼接查询语句
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select ");
        buffer.append(" g.id,g.idcode,g.productName,g.price,g.salesVolume,g.inStock,g.store,g.factory," +
                "g.shelflife,g.img,g.discount,g.situation,g.post," +
                "g.createTime,c.id,c.category");
        buffer.append(" from goods g ");
        buffer.append(" inner join category c ");
        buffer.append(" on g.idcode = c.id ");
        buffer.append(" WHERE g.situation = '上架'");
//		判断goods有无数据
        if (goods != null) {
//			根据商品名称
            if (goods.getProductName() != null && goods.getProductName().trim().length() > 0) {
                buffer.append(" and g.productName like '%" + goods.getProductName() + "%'");
            }
//			根据价格
            if (goods.getPrice() != null && goods.getPrice().trim().length() > 0) {
                buffer.append(" and g.price = " + goods.getPrice());
            }

//			根据库存

            if (goods.getIdcode() != null && goods.getIdcode().trim().length() > 0) {
                buffer.append(" and g.idcode = " + goods.getIdcode());
            }

//			根据销量

            if (goods.getSalesVolume() != null && goods.getSalesVolume().trim().length() > 0) {
                buffer.append(" and  g.salesVolume = " + goods.getSalesVolume());
            }
//			根据类别
            if (goods.getTypeName() != null && goods.getTypeName().trim().length() > 0) {
                buffer.append(" and c.category = '" + goods.getTypeName() + "'");
            }
//			根据店家
            if (goods.getStore() != null && goods.getStore().trim().length() > 0) {
                buffer.append(" and g.store  like '%" + goods.getStore() + "%'");
            }
//			根据保质期
            if (goods.getShelflife() != null && goods.getShelflife().trim().length() > 0) {
                buffer.append(" and g.shelflife  like '" + goods.getShelflife() + "'");
            }
//			根据邮递
            if (goods.getPost() != null && goods.getPost().trim().length() > 0) {
                buffer.append(" and g.post  = '" + goods.getPost() + "'");
            }
//			根据图片
            if (goods.getImg() != null && goods.getImg().trim().length() > 0) {
                buffer.append(" and g.img  like '%" + goods.getImg() + "%'");
            }

//			根据厂家
            if (goods.getFactory() != null && goods.getFactory().trim().length() > 0) {
                buffer.append(" and g.factory like '%" + goods.getFactory() + "%'");
            }

//			根据折扣
            if (goods.getDiscount() != null && goods.getDiscount().trim().length() > 0) {
                buffer.append(" and g.discount  = '" + goods.getDiscount() + "'");
            }

//			根据状态
            if (goods.getSituation() != null && goods.getSituation().trim().length() > 0) {
                buffer.append(" and g.situation  = '" + goods.getSituation() + "'");
            }

        }
//		分页查询
//		pageSize 每次展示数据的条数
        buffer.append(" order by g.id asc ");
        String sql = buffer.toString();

        List<Goods> goodsList = JDBCTemplate.executeQUery(sql, new GoodsMapper(), null);
        return goodsList;
    }


    /**
     * 根据商品ID查询最后一条数据
     */
    @Override
    public List<Goods> selectGoodsAtLast() {


//		查询语句
        String sql = "select g.id,g.productName,g.idcode,g.price,g.salesVolume," +
                " g.inStock,g.factory,g.store,g.shelflife,g.img,g.post," +
                " g.discount,g.situation,g.createTime,c.category from goods g inner " +
                " join category c " +
                " on g.idcode = c.id " +
                " order by id desc limit 1 ";
//		获取查寻到的数据
        List<Goods> goodsList = JDBCTemplate.executeQUery(sql, new GoodsMapper(), null);
//		遍历集合输出
        return goodsList;
    }

}



