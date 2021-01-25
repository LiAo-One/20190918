package com.liao.test;

import java.util.List;
import java.util.Scanner;

import com.liao.entity.Goods;
import com.liao.factory.ObjectFactory;
import com.liao.service.GoodsService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class GoodsTest {
    //	获取输入方法
    static Scanner sc = new Scanner(System.in);
    //	新建一个用户对象
    static Goods goods = new Goods();
    //	使用多态指向子类
    static GoodsService goodsService = (GoodsService) ObjectFactory.getBean("GoodsService");

    public static void main(String[] args) {
//		add();//添加
//		delect();//删除
//		modif();//修改
//		show();//模糊查询
//		showAll();

    }

    public static void showAll() {
        ResJson json = goodsService.selectGoodsAll();
        List<Goods> goods = json.getList();
        System.out.println(goods.toString());
    }

    /**
     * 添加
     */
    public static void add() {
        Goods goods = data();
        System.out.println(goodsService.addGoods(goods));
    }

    /**
     * 删除
     */
    public static void delect() {
        System.out.println("输入要删除的数据如 1");
        String str = sc.next();
        goods.setId(str);
        System.out.println(goodsService.deleGoods(goods));
        goodsService.selectGoodsAll();
    }

    /**
     * 修改
     */
    public static void modif() {
        System.out.println("输入要修改的数据ID如 1");
        String modiID = sc.next();
        goods.setId(modiID);
        Goods goods = data();
        System.out.println(goodsService.modiGoods(goods));
        goodsService.selectGoodsAll();
    }

    /**
     * 模糊查询
     */
    public static void show() {
        System.out.println("请输入数据 如 手机");
        String str = sc.next();
        goods.setId(str);
        goods.setProductName(str);
        goods.setIdcode(str);
        goods.setPrice(str);
        goods.setSalesVolume(str);
        goods.setInStock(str);
        goods.setFactory(str);
        goods.setStore(str);
        goods.setShelflife(str);
        goods.setSituation(str);
        goods.setCreateTime(str);
        goods.setDiscount(str);
        goods.setPost(str);
        goods.setImg(str);

        goodsService.showGoods(goods);
    }

    /**
     * 将用户输入的修改和添加数据分割封装成一个方法
     */
    public static Goods data() {
        System.out.println("请输入数据 如 Mi,14512,手机,2499.00,12,1,北京市小米科技,小米之家," +
                "四曲面玻璃,12,下架,9.9,否,1.jpg");
        String str = sc.next();
        String[] strs = str.split(",");
        goods.setProductName(strs[0]);
        goods.setIdcode(strs[1]);
        goods.setPrice(strs[3]);
        goods.setSalesVolume(strs[4]);
        goods.setInStock(strs[5]);
        goods.setFactory(strs[6]);
        goods.setStore(strs[7]);
        goods.setShelflife(strs[9]);
        goods.setSituation(strs[10]);
        goods.setDiscount(strs[11]);
        goods.setPost(strs[12]);
        goods.setImg(strs[13]);
        System.out.println(goods.toString());
        return goods;
    }
}
