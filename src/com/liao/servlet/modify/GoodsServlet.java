package com.liao.servlet.modify;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.entity.Goods;
import com.liao.factory.ObjectFactory;
import com.liao.service.GoodsService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class GoodsServlet extends HttpServlet {
    GoodsService goodsService = (GoodsService) ObjectFactory.getBean("GoodsService");

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

        this.doPost(request, response);
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

//		获取ID
        String id = request.getParameter("id");
//		获取名称
        String name = request.getParameter("name");
//		获取价格
        String price = request.getParameter("price");
//		获取类别
        String category = request.getParameter("category");
//		获取保质期
        String shelflife = request.getParameter("shelflife");
//		获取邮递
        String post = request.getParameter("post");
//		获取图片
        String img = request.getParameter("img");
//		获取库存
        String inStock = request.getParameter("inStock");
//		获取销量
        String salesVolume = request.getParameter("salesVolume");
//		获取厂家
        String factory = request.getParameter("factory");
//		获取店家
        String store = request.getParameter("store");
//		获取折扣
        String discount = request.getParameter("discount");
//		获取状态
        String situation = request.getParameter("situation");

        Goods g = new Goods();
//		获取ID
        g.setId(id);
//		获取名称
        g.setProductName(name);
//		获取价格
        g.setPrice(price);
//		获取类别
        g.setIdcode(category);
//		获取保质期
        g.setShelflife(shelflife);
//		获取邮递
        g.setPost(post);
//		获取图片
        g.setImg(img);
//		获取库存
        g.setInStock(inStock);
//		获取销量
        g.setSalesVolume(salesVolume);
//		获取厂家
        g.setFactory(factory);
//		获取店家
        g.setStore(store);
//		获取折扣
        g.setDiscount(discount);
//		获取状态
        g.setSituation(situation);

        String json = "";
//		ResJson resJson = goodsService.modiGoods(g);
//		
//		if(resJson.getSub()){
////			获取当前登录的用户
//			
//    		json = "{\"isSuccess\":\"true\",\"goods\":\""+null+"\",\"message\":\""+resJson.getStr()+"\"}";
//		}else{
////			失败
//			json = "{\"isSuccess\":\"false\",\"goods\":\""+null+"\",\"message\":\""+resJson.getStr()+"\"}";
//		}


        out.print(json);

        out.flush();
        out.close();
    }

}
