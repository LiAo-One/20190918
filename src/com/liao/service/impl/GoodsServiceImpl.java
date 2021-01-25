package com.liao.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;


import com.liao.dao.GoodsDao;
import com.liao.entity.Goods;
import com.liao.exception.AddBookExcoption;
import com.liao.exception.DeleExcoption;
import com.liao.exception.ModiExcoption;
import com.liao.exception.ShowIDExcoption;
import com.liao.factory.ObjectFactory;
import com.liao.service.GoodsService;
import com.liao.util.ResJson;

public class GoodsServiceImpl implements GoodsService {
    //	事物
    private GoodsDao goodsDao = (GoodsDao) ObjectFactory.getBean("GoodsDao");

    /**
     * 商品添加方法
     */
    @Override
    public ResJson addGoods(Goods goods) {
        ResJson rejo = new ResJson();
        int count = 0;
        try {
//			判断添加参数是否为空
            if (goods == null) {
                throw new AddBookExcoption("添加异常： 添加的数据为空");
            }
//			判断商品名称数据是否存在
            if (goods.getProductName() == null || goods.getProductName().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 请输入商品名称");
            }

//			判断类别ID数据是否存在
            if (goods.getIdcode() == null || goods.getIdcode().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 请输入商品类别ID");
            }

//			判断商品价格数据是否存在
            if (goods.getPrice() == null || goods.getPrice().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 请输入商品价格");
            }
//			判断价格是否合法
            if (!goods.getPrice().matches("(\\d+(\\.\\d+)?)")) {
                throw new AddBookExcoption("价格不合法 如 10");
            }
//			判断销量数据是否存在
            if (goods.getSalesVolume() == null || goods.getSalesVolume().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 请输入商品销量");
            }
//			判断销量是否合法
            if (!goods.getSalesVolume().matches("^[1-9][0-9]*$")) {
                throw new AddBookExcoption("销量不合法 如 1000");
            }

//			判断店家名称数据是否存在
            if (goods.getStore() == null || goods.getStore().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 请输入商品店家名称");
            }

//			判断库存数据是否存在
            if (goods.getInStock() == null || goods.getInStock().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 请输入商品库存");
            }
//			判断库存是否合法
            if (!goods.getInStock().matches("^[1-9][0-9]*$")) {
                throw new AddBookExcoption("库存不合法 如122");
            }
//			判断厂家数据是否存在
            if (goods.getFactory() == null || goods.getFactory().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 请输入厂家");
            }

//			判断保质期数据是否存在
            if (goods.getShelflife() == null || goods.getShelflife().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 请输入保质期，或者输入 无 ");
            }
//			判断保质期是否合法
            if (!goods.getShelflife().matches("^[1-9][0-9]*[天月年]$|[无]")) {
                throw new AddBookExcoption("保质期不合法，数字后加 年 月 日 单位 或者输入 无");
            }

//			判断数据是否存在
            if (goods.getImg() == null || goods.getImg().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 请输入商品图片链接");
            }

//			判断折扣数据是否存在
            if (goods.getDiscount() == null || goods.getDiscount().trim().length() == 0) {
                goods.setDiscount("0");
            }
            if (!goods.getDiscount().matches("\\d{0,3}折|[0]")) {
                throw new AddBookExcoption("折扣输入不合法 如 75折");
            }
//			判断数据是否存在
            if (goods.getSituation() == null || goods.getSituation().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 请输入商品状态");
            }

//			判断状态是否合法
            if (!(goods.getSituation().equals("上架") || goods.getSituation().equals("下架"))) {
                throw new ModiExcoption("状态只可输入 “上架” 或 “下架” ");
            }

//			判断数据是否存在
            if (goods.getPost() == null || goods.getPost().trim().length() == 0) {
                throw new AddBookExcoption("添加异常： 请输入商品是否包邮");
            }

//			判断邮递是否合法
            if (!(goods.getPost().equals("是") || goods.getPost().equals("否"))) {
                throw new AddBookExcoption("邮递只可输入 “是” 或 “否” ");
            }

            count = goodsDao.addGoods(goods);
//			执行添加
//			判断添加是否成功
            if (count > 0) {
//				成功
                rejo.setSub(true);
                rejo.setStr("添加成功");
            } else {
//				失败
                rejo.setSub(false);
                rejo.setStr("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            rejo.setSub(false);
            rejo.setStr(e.getMessage());

        }
//		返回结果
        return rejo;
    }

    /**
     * 删除
     */
    @Override
    public ResJson deleGoods(Goods goods) {
        ResJson json = new ResJson();
//		存储删除的结果
        int count = 0;
        try {
//			判断参数是否为空
            if (goods == null) {
                throw new DeleExcoption("删除异常： 删除的数据为空");
            }

            if (goods.getId() == null || goods.getId().trim().length() == 0) {
                throw new DeleExcoption("删除异常： 删除的id为空");
            }
//			执行删除
            count = goodsDao.deleGoods(goods);
//			判断结果
            if (count > 0) {
//				成功
                json.setSub(true);
                json.setStr("已为您执行下架功能");
            } else {
//				失败
                json.setSub(false);
                json.setStr("失败");
            }

        } catch (Exception e) {
//			异常
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
        }
//		返回结果
        return json;
    }

    /**
     * 修改方法
     */
    @Override
    public ResJson modiGoods(Goods goods) {
        ResJson json = new ResJson();
        int count = 0;
        try {
//			判断参数是否为空
            if (goods == null) {
                throw new ModiExcoption("修改异常： 修改的数据为空");
            }
//			判断商品名称数据是否存在
            if (goods.getProductName() == null || goods.getProductName().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 请输入商品名称");
            }

//			判断类别ID数据是否存在
            if (goods.getIdcode() == null || goods.getIdcode().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 请输入商品类别ID");
            }

//			判断商品价格数据是否存在
            if (goods.getPrice() == null || goods.getPrice().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 请输入商品价格");
            }
//			判断价格是否合法
            if (!goods.getPrice().matches("(\\d+(\\.\\d+)?)")) {
                throw new AddBookExcoption("价格不合法");
            }
//			判断销量数据是否存在
            if (goods.getSalesVolume() == null || goods.getSalesVolume().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 请输入商品销量");
            }
//			判断销量是否合法
            if (!goods.getSalesVolume().matches("^[1-9][0-9]*$")) {
                throw new AddBookExcoption("销量不合法");
            }

//			判断店家名称数据是否存在
            if (goods.getStore() == null || goods.getStore().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 请输入商品店家名称");
            }

//			判断库存数据是否存在
            if (goods.getInStock() == null || goods.getInStock().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 请输入商品库存");
            }
//			判断库存是否合法
            if (!goods.getInStock().matches("^[1-9][0-9]*$")) {
                throw new AddBookExcoption("库存不合法");
            }
//			判断厂家数据是否存在
            if (goods.getFactory() == null || goods.getFactory().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 请输入厂家");
            }

//			判断保质期数据是否存在
            if (goods.getShelflife() == null || goods.getShelflife().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 请输入保质期，或者输入0");
            }
//			判断保质期是否合法
//			判断保质期是否合法
            if (!goods.getShelflife().matches("^[1-9][0-9]*[天月年]$|[无]")) {
                throw new AddBookExcoption("保质期不合法，数字后加 年 月 日 单位 或者输入 无");
            }

//			判断数据是否存在
            if (goods.getImg() == null || goods.getImg().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 请输入商品图片链接");
            }

//			判断折扣数据是否存在
            if (goods.getDiscount() == null || goods.getDiscount().trim().length() == 0) {
                goods.setDiscount("0");
            }
            if (!goods.getDiscount().matches("\\d{0,3}折|[0]")) {
                throw new AddBookExcoption("折扣输入不合法 如 75折或者0");
            }
//			判断数据是否存在
            if (goods.getSituation() == null || goods.getSituation().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 请输入商品状态");
            }

//			判断状态是否合法
            if (!(goods.getSituation().equals("上架") || goods.getSituation().equals("下架"))) {
                throw new ModiExcoption("状态只可输入 “上架” 或 “下架” ");
            }

//			判断数据是否存在
            if (goods.getPost() == null || goods.getPost().trim().length() == 0) {
                throw new AddBookExcoption("修改异常： 请输入商品是否包邮");
            }

//			判断邮递是否合法
            if (!(goods.getPost().equals("是") || goods.getPost().equals("否"))) {
                throw new AddBookExcoption("邮递只可输入 “是” 或 “否” ");
            }
//			执行修改
            count = goodsDao.modiGoods(goods);
            System.out.println(goods.getIdcode());
//			判断修改是否成功
            if (count > 0) {
//				成功
                json.setSub(true);
                json.setStr("修改成功");
            } else {
//				失败
                json.setSub(false);
                json.setStr("修改失败");
            }

        } catch (Exception e) {
//			异常
            e.printStackTrace();
            json.setStr(e.getMessage());
        }
//		返回结果
        return json;
    }

    /**
     * 查询全部
     */
    @Override
    public ResJson selectGoodsAll() {
        ResJson json = new ResJson();
//		调用查询方法
        List<Goods> goodsList = goodsDao.selectGoodsAll();
//		判断查询是否成功
        try {
//			成功
            if (goodsList != null) {
                json.setSub(true);
                json.setStr("查询成功");
                json.setList(goodsList);
            }

        } catch (Exception e) {
//			异常
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
            json.setList(null);
        }
        System.out.println(json.getList());
//		返回结果
        return json;
    }


    /**
     * 模糊查询
     *
     * @param goods
     */
    @Override
    public void showGoods(Goods goods) {
        try {
            if (goods == null) {
                throw new ShowIDExcoption("查询异常 ：查询的数据为空");
            }
            goodsDao.showGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 按照条件查询数据
     */
    @Override
    public ResJson selectGoodsByLimit(int pageNum, int pageSize, Goods goods) {
        ResJson rejs = new ResJson();
//		判断分页参数是否合法
        try {
            if (pageNum < 1) {
                throw new ShowIDExcoption("pageNum不合法");
            }

            if (pageSize < 1) {
                throw new ShowIDExcoption("pageSize不合法");
            }
//			获取查询的结果集
            List<Goods> goodsList = goodsDao.selectGoodsByLimit(pageNum, pageSize, goods);
//			成功
            rejs.setSub(true);
            rejs.setStr("查询成功");
            rejs.setList(goodsList);
        } catch (Exception e) {
//			异常
            rejs.setSub(false);
            rejs.setStr(e.getMessage());
            rejs.setList(null);
        }

//		返回结果
        return rejs;
    }

    /**
     * 按照条件查询数量
     *
     * @param goods 查询参数
     * @return 返回查询到数据的条数
     */
    @Override
    public int selectGoodsCouny(Goods goods) {
//		存储查询到数据长度
        int count = 0;
//		获取查询到的数据集合
        List<Goods> goodsList = goodsDao.selectGoodsCouny(goods);
//		获取集合长度
        count = goodsList.size();
//		返回集合长度
        return count;
    }

    /**
     * 导入数据
     */
    @Override
    public ResJson importGoods() {
        Goods goods = new Goods();
//		存储结果
        int num = 0;
        ResJson json = new ResJson();
        int count = 0;
//		输入流
        BufferedReader buff = null;
        try {
//			输入流
            buff = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("rpload.txt")));
//			存储读取的文本
            String str = "";
            while ((str = buff.readLine()) != null) {
//				分割数据
                String[] strs = str.split(",");
                goods.setIdcode(strs[0]);
                goods.setProductName(strs[1]);
                goods.setPrice(strs[2]);
                goods.setSalesVolume(strs[3]);
                goods.setInStock(strs[4]);
                goods.setStore(strs[5]);
                goods.setFactory(strs[6]);
                goods.setShelflife(strs[7]);
                goods.setImg(strs[8]);
                goods.setDiscount(strs[9]);
                goods.setSituation(strs[10]);
                goods.setPost(strs[11]);
//				添加方法
                count = goodsDao.addGoods(goods);
//				计数器
                num++;
            }
//			判断结果
            if (count > 0) {
//				成功
                json.setSub(true);
                json.setStr("导入成功" + num + "条");
            } else {
//				失败
                json.setSub(false);
                json.setStr("导入失败");
            }
        } catch (Exception e) {
//		关闭流
        } finally {
            if (buff != null) {
                try {
                    buff.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//		返回结果
        return json;
    }

    /**
     * 下载
     */
    @Override
    public ResJson download(Goods goods) {
        ResJson json = new ResJson();
//		输出流
        BufferedWriter buffw = null;
//		计数器
        int num = 0;
        try {
//			输出流
            buffw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("download.txt")));
//			获取返回值
            List<Goods> goodsList = goodsDao.download(goods);
//			循环遍历集合
            if (goodsList.size() > 0) {
                for (Goods goods2 : goodsList) {
                    buffw.write(goods2.toString());
//					写入数据
                    buffw.newLine();
//					刷新输出流
                    buffw.flush();
//					计数器
                    num++;
                    json.setSub(true);
                    json.setStr("数据下载成功" + num + "条");
                }
            } else {
//				失败
                json.setSub(false);
                json.setStr("暂无数据");
            }
        } catch (Exception e) {
//			关闭流
        } finally {
            if (buffw != null) {
                try {
                    buffw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
//		返回结果
        return json;
    }


    /**
     * 查询最后一条商品
     */
    @Override
    public ResJson selectGoodsAtLast() {

        ResJson json = new ResJson();
//		调用查询方法
        List<Goods> goodsList = goodsDao.selectGoodsAtLast();
//		判断查询是否成功
        try {
//			成功
            if (goodsList != null) {
                json.setSub(true);
                json.setStr("查询成功");
                json.setList(goodsList);
            }

        } catch (Exception e) {
//			异常
            e.printStackTrace();
            json.setSub(false);
            json.setStr(e.getMessage());
            json.setList(null);
        }
        System.out.println(json.getList());
//		返回结果
        return json;
    }

}









