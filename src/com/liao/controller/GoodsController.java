package com.liao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.entity.Goods;
import com.liao.entity.GoodsImg;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.GoodsImgService;
import com.liao.service.GoodsService;
import com.liao.service.UserService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
/**
 * 商品操作
 *
 * @author soft01
 *
 */
public class GoodsController {

    private GoodsService goodsService = (GoodsService) ObjectFactory.getBean("GoodsService");

    private GoodsImgService goodsImgService = (GoodsImgService) ObjectFactory.getBean("GoodsImgService");

    /**
     * 商品添加
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void goodsAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 获取商品图片
        String imgList = request.getParameter("imgList");

        // 分割商品图片数据
        String[] goodsImg = imgList.split(",");

        // 获取名称
        String name = request.getParameter("name");
        // 获取价格
        String price = request.getParameter("price");
        // 获取类别
        String category = request.getParameter("category");
        // 获取保质期
        String shelflife = request.getParameter("shelflife");
        // 获取邮递
        String post = request.getParameter("post");
        // 获取图片
        String img = request.getParameter("img");
        // 获取库存
        String inStock = request.getParameter("inStock");
        // 获取销量
        String salesVolume = request.getParameter("salesVolume");
        // 获取厂家
        String factory = request.getParameter("factory");
        // 获取店家
        String store = request.getParameter("store");
        // 获取折扣
        String discount = request.getParameter("discount");
        // 获取状态
        String situation = request.getParameter("situation");

        Goods g = new Goods();
        // 获取名称
        g.setProductName(name);
        // 获取价格
        g.setPrice(price);
        // 获取类别
        g.setIdcode(category);
        // 获取保质期
        g.setShelflife(shelflife);
        // 获取邮递
        g.setPost(post);
        // 获取图片
        g.setImg(img);
        // 获取库存
        g.setInStock(inStock);
        // 获取销量
        g.setSalesVolume(salesVolume);
        // 获取厂家
        g.setFactory(factory);
        // 获取店家
        g.setStore(store);
        // 获取折扣
        g.setDiscount(discount);
        // 获取状态
        g.setSituation(situation);

        String json = "";
        ResJson resJson = goodsService.addGoods(g);

        if (resJson.getSub()) {
            // 查询刚才添加的一条数据
            ResJson imgJson = goodsService.selectGoodsAtLast();

            List<Goods> idList = imgJson.getList();
            Goods goodsId = idList.get(0);
            for (int i = 0; i < goodsImg.length; i++) {
                // 循环调用方法添加进商品图片
                GoodsImg imgAdd = new GoodsImg();
                // 商品ID
                imgAdd.setGoodsId(goodsId.getId());
//				图片名称
                imgAdd.setName(goodsImg[i]);
                ResJson imgAddJsom = goodsImgService.addGoodsImg(imgAdd);
            }

            // 添加成功
            json = "{\"isSuccess\":\"true\",\"goods\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";

        } else {
            // 失败
            json = "{\"isSuccess\":\"false\",\"goods\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        }

        out.print(json);

        out.flush();
        out.close();
    }

    /**
     * 商品修改
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void goodsModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 获取商品图片
        String imgList = request.getParameter("imgList");

        // 分割商品图片数据
        String[] goodsImg = imgList.split(",");

        // 获取ID
        String id = request.getParameter("id");
        // 获取名称
        String name = request.getParameter("name");
        // 获取价格
        String price = request.getParameter("price");
        // 获取类别
        String category = request.getParameter("category");
        // 获取保质期
        String shelflife = request.getParameter("shelflife");
        // 获取邮递
        String post = request.getParameter("post");
        // 获取图片
        String img = request.getParameter("img");
        // 获取库存
        String inStock = request.getParameter("inStock");
        // 获取销量
        String salesVolume = request.getParameter("salesVolume");
        // 获取厂家
        String factory = request.getParameter("factory");
        // 获取店家
        String store = request.getParameter("store");
        // 获取折扣
        String discount = request.getParameter("discount");
        // 获取状态
        String situation = request.getParameter("situation");

        Goods g = new Goods();
        // 获取ID
        g.setId(id);
        // 获取名称
        g.setProductName(name);
        // 获取价格
        g.setPrice(price);
        // 获取类别
        g.setIdcode(category);
        // 获取保质期
        g.setShelflife(shelflife);
        // 获取邮递
        g.setPost(post);
        // 获取图片
        g.setImg(img);
        // 获取库存
        g.setInStock(inStock);
        // 获取销量
        g.setSalesVolume(salesVolume);
        // 获取厂家
        g.setFactory(factory);
        // 获取店家
        g.setStore(store);
        // 获取折扣
        g.setDiscount(discount);
        // 获取状态
        g.setSituation(situation);

        String json = "";
        ResJson resJson = goodsService.modiGoods(g);

        if (resJson.getSub()) {
//			先删除，后添加，完成图片修改
            GoodsImg goodsImgID = new GoodsImg();

            goodsImgID.setGoodsId(id);
            // 查询刚才添加的一条数据
            goodsImgService.deleteGoodsImg(goodsImgID);

            for (int i = 0; i < goodsImg.length; i++) {
                // 循环调用方法添加进商品图片
                GoodsImg imgAdd = new GoodsImg();
                // 商品ID
                imgAdd.setGoodsId(id);
                imgAdd.setName(goodsImg[i]);
                ResJson imgAddJsom = goodsImgService.addGoodsImg(imgAdd);
            }
            // 成功
            json = "{\"isSuccess\":\"true\",\"goods\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        } else {
            // 失败
            json = "{\"isSuccess\":\"false\",\"goods\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        }

        out.print(json);

        out.flush();
        out.close();
    }

    /**
     * 商品删除
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void goodsDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        // 获取ID
        String id = request.getParameter("id");

        Goods g = new Goods();
        // 获取ID
        g.setId(id);

        String json = "";
        ResJson resJson = goodsService.deleGoods(g);

        if (resJson.getSub()) {
            // 获取当前登录的用户

            json = "{\"isSuccess\":\"true\",\"goods\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        } else {
            // 失败
            json = "{\"isSuccess\":\"false\",\"goods\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        }

        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * 商品分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void goodsSelectPaginaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));


        // 获取查询条件
        String goodsPrice = request.getParameter("goodsPrice");
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String store = request.getParameter("store");

        Goods g = new Goods();
        g.setPrice(goodsPrice);
        g.setProductName(name);
        g.setIdcode(category);
        g.setStore(store);

        int count = goodsService.selectGoodsCouny(g);


        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        String imgJsonStr = "";

        ResJson rejson = goodsService.selectGoodsByLimit(pageNum, pageSize, g);

        List<Goods> goodsList = rejson.getList();

        for (int i = 0; i < goodsList.size(); i++) {
            Goods goods = goodsList.get(i);

            ResJson imgJson = goodsImgService.selectGoodsImg(goods);

            List<GoodsImg> imgList = imgJson.getList();
            
            goods.setImg(imgList.get(0).getName());
            
            // 拼接每一张图片
            imgJsonStr = "[";

            // 判断是否有图片
            if (imgList != null) {
                // 遍历集合 将该商品对应的所有图片全部取出
                for (int j = 0; j < imgList.size(); j++) {
                    // 获取当前商品图片对象
                    GoodsImg img = imgList.get(j);
                    // 获取每一张图片 并拼接
                    imgJsonStr += "{\"id\":\"" + img.getId() + "\",\"name\":\"" + img.getName() + "\",\"goodsId\":\"" + img.getGoodsId() + "\",\"createTime\":\"" + img.getTime() + "\"},";
                }
                imgJsonStr = imgJsonStr.substring(0, imgJsonStr.length() - 1);
            }


            imgJsonStr = imgJsonStr + "]";

            json += "{\"id\":\"" + goods.getId() + "\"," +
                    // 商品名称
                    "\"productName\":\"" + goods.getProductName() + "\"," +
                    // 类别id
                    "\"idcode\":\"" + goods.getIdcode() + "\"" +
                    // 价格
                    ",\"price\":\"" + goods.getPrice() + "\"" +
                    // 销量
                    ",\"salesVolume\":\"" + goods.getSalesVolume() + "\"" +
                    // 库存
                    ",\"inStock\":\"" + goods.getInStock() + "\"" +
                    // 厂家
                    ",\"factory\":\"" + goods.getFactory() + "\"" +
                    // 店家;
                    ",\"store\":\"" + goods.getStore() + "\"" +
                    // 保质期
                    ",\"shelflife\":\"" + goods.getShelflife() + "\"" +
                    // 状态
                    ",\"situation\":\"" + goods.getSituation() + "\"" +
                    // 创建时间
                    ",\"createTime\":\"" + goods.getCreateTime() + "\"" +
                    // 折扣
                    ",\"Discount\":\"" + goods.getDiscount() + "\"" +
                    // 是否包邮
                    ",\"post\":\"" + goods.getPost() + "\"" +
                    // 图片集合
                    ",\"typeName\":\"" + "" + goods.getTypeName() + "" + "\"" +
                    // 商品图片
                    ",\"img\":\"" + goods.getImg() + "\",\"imgList\":" + imgJsonStr + "\"},";
            // 商品类别
            // ",\"imgList\":\""+imgJsonStr+"\"},";

            json = json.substring(0, json.length() - 3) + "},";

        }

        json = json.substring(0, json.length() - 1) + "]}";

        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * 查询所有商品
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void goodsSelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        int count = goodsService.selectGoodsCouny(null);

        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        ResJson rejson = goodsService.selectGoodsByLimit(1, 8, null);

        List<Goods> goodsList = rejson.getList();

        for (int i = 0; i < goodsList.size(); i++) {
            Goods goods = goodsList.get(i);

            json += "{\"id\":\"" + goods.getId() + "\"," +
                    // 商品名称
                    "\"productName\":\"" + goods.getProductName() + "\"," +
                    // 类别id
                    "\"idcode\":\"" + goods.getIdcode() + "\"" +
                    // 价格
                    ",\"price\":\"" + goods.getPrice() + "\"" +
                    // 销量
                    ",\"salesVolume\":\"" + goods.getSalesVolume() + "\"" +
                    // 库存
                    // ",\"inStock\":\""+goods.getInStock()+"\"" +
                    // 厂家
                    // ",\"factory\":\""+goods.getFactory()+"\"" +
                    // 店家;
                    ",\"store\":\"" + goods.getStore() + "\"" +
                    // 保质期
                    // ",\"shelflife\":\""+goods.getShelflife()+"\"" +
                    // 状态
                    // ",\"situation\":\""+goods.getSituation()+"\"" +
                    // 创建时间
                    // ",\"createTime\":\""+goods.getCreateTime()+"\"" +
                    // 折扣
                    ",\"Discount\":\"" + goods.getDiscount() + "\"" +
                    // 是否包邮
                    ",\"post\":\"" + goods.getPost() + "\"" +
                    // 商品图片
                    ",\"img\":\"" + goods.getImg() + "\"" +
                    // 商品类别
                    ",\"typeName\":\"" + goods.getTypeName() + "\"},";
        }

        json = json.substring(0, json.length() - 1) + "]}";

        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * 根据商品ID查询图片数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void showGoodsIdImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Goods g = new Goods();
         g.setId(request.getParameter("goodsImgId"));

        String json = "";

        ResJson imgJson = goodsImgService.selectGoodsImg(g);

        List<GoodsImg> imgList = imgJson.getList();
         
        // 拼接每一张图片
        String imgJsonStr = "{\"total\":\"" + imgList.size() + "\",\"rows\":[";

        // 判断是否有图片
        if (imgList != null) {
            // 遍历集合 将该商品对应的所有图片全部取出
            for (int j = 0; j < imgList.size(); j++) {
                // 获取当前商品图片对象
                GoodsImg img = imgList.get(j);
                // 获取每一张图片 并拼接
                imgJsonStr += "{\"id\":\"" + img.getId() + "\",\"name\":\"" + img.getName() + "\",\"goodsId\":\"" + img.getGoodsId() + "\",\"createTime\":\"" + img.getTime() + "\"},";
            }
            imgJsonStr = imgJsonStr.substring(0, imgJsonStr.length() - 1);
        }


        imgJsonStr = imgJsonStr + "]}";

        out.print(imgJsonStr);
        out.flush();
        out.close();
    }
}
