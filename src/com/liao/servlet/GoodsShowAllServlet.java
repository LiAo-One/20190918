package com.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.entity.Goods;
import com.liao.factory.ObjectFactory;
import com.liao.service.GoodsService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class GoodsShowAllServlet extends HttpServlet {
    static GoodsService goodsService =
            (GoodsService) ObjectFactory.getBean("GoodsService");

    /**
     * Constructor of the object.
     */
    public GoodsShowAllServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
//					商品名称
                    "\"productName\":\"" + goods.getProductName() + "\"," +
//					类别id
                    "\"idcode\":\"" + goods.getIdcode() + "\"" +
//					价格
                    ",\"price\":\"" + goods.getPrice() + "\"" +
//					销量
                    ",\"salesVolume\":\"" + goods.getSalesVolume() + "\"" +
//					库存
//					",\"inStock\":\""+goods.getInStock()+"\"" +
//					厂家
//					",\"factory\":\""+goods.getFactory()+"\"" +
//					店家;
                    ",\"store\":\"" + goods.getStore() + "\"" +
//					保质期
//					",\"shelflife\":\""+goods.getShelflife()+"\"" +
//					状态
//					",\"situation\":\""+goods.getSituation()+"\"" +
//					创建时间
//					",\"createTime\":\""+goods.getCreateTime()+"\"" +
//					折扣
                    ",\"Discount\":\"" + goods.getDiscount() + "\"" +
//					是否包邮
                    ",\"post\":\"" + goods.getPost() + "\"" +
//					商品图片
                    ",\"img\":\"" + goods.getImg() + "\"" +
//					商品类别
                    ",\"typeName\":\"" + goods.getTypeName() + "\"},";
        }

        json = json.substring(0, json.length() - 1) + "]}";

        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
    }

}
