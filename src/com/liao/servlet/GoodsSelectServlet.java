package com.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.entity.Category;
import com.liao.entity.Goods;
import com.liao.entity.GoodsImg;
import com.liao.factory.ObjectFactory;
import com.liao.service.CategoryService;
import com.liao.service.GoodsImgService;
import com.liao.service.GoodsService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class GoodsSelectServlet extends HttpServlet {
    private GoodsService goodsService =
            (GoodsService) ObjectFactory.getBean("GoodsService");

    private GoodsImgService goodsImgService =
            (GoodsImgService) ObjectFactory.getBean("GoodsImgService");

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * The doPost method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));

        String goodsName = request.getParameter("goodsName");
        int count = goodsService.selectGoodsCouny(null);

        Goods g = new Goods();
        g.setProductName(goodsName);


        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        String imgJsonStr = "";


        ResJson rejson = goodsService.selectGoodsByLimit(pageNum, pageSize, null);


        List<Goods> goodsList = rejson.getList();

        for (int i = 0; i < goodsList.size(); i++) {
            Goods goods = goodsList.get(i);

            ResJson imgJson = goodsImgService.selectGoodsImg(goods);

            List<GoodsImg> imgList = imgJson.getList();

            // 拼接每一张图片
            imgJsonStr = "[";
            // 遍历集合 将该商品对应的所有图片全部取出
            for (int j = 0; j < imgList.size(); j++) {
                // 获取当前商品图片对象
                GoodsImg img = imgList.get(j);
                // 获取每一张图片 并拼接
                imgJsonStr += "{\"id\":\"" + img.getId() + "\",\"name\":\"" + img.getName() + "\",\"goodsId\":\"" + img.getGoodsId() + "\",\"createTime\":\"" + img.getTime() + "\"},";
            }

            imgJsonStr = imgJsonStr.substring(0, imgJsonStr.length() - 1) + "]";

            json += "{\"id\":\"" + goods.getId() + "\"," +
//					商品名称
                    "\"productName\":\"" + goods.getProductName() + "\"," +
//					类别id
                    "\"idcode\":\"" + goods.getIdcode() + "\"" +
//					价格
                    ",\"price\":\"" + goods.getPrice() + "\"" +
//					销量
                    ",\"salesVolume\":\"" + goods.getSalesVolume() + "\"" +
//					库存
                    ",\"inStock\":\"" + goods.getInStock() + "\"" +
//					厂家
                    ",\"factory\":\"" + goods.getFactory() + "\"" +
//					店家;
                    ",\"store\":\"" + goods.getStore() + "\"" +
//					保质期
                    ",\"shelflife\":\"" + goods.getShelflife() + "\"" +
//					状态
                    ",\"situation\":\"" + goods.getSituation() + "\"" +
//					创建时间
                    ",\"createTime\":\"" + goods.getCreateTime() + "\"" +
//					折扣
                    ",\"Discount\":\"" + goods.getDiscount() + "\"" +
//					是否包邮
                    ",\"post\":\"" + goods.getPost() + "\"" +
//					图片集合
                    ",\"typeName\":\"" + "" + goods.getTypeName() + "" + "\"" +
//					商品图片
                    ",\"img\":\"" + goods.getImg() + "\",\"imgList\":" + imgJsonStr + "\"},";
//					商品类别
//					",\"imgList\":\""+imgJsonStr+"\"},";

            json = json.substring(0, json.length() - 3) + "},";


        }


        json = json.substring(0, json.length() - 1) + "]}";

        System.out.println(imgJsonStr);

        out.print(json);

        out.flush();
        out.close();
    }

}
