package com.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.entity.ShoppingCart;
import com.liao.factory.ObjectFactory;
import com.liao.service.ShoppingCartService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class ShoppingCartServlet extends HttpServlet {
    ShoppingCartService shoppingCartService = (ShoppingCartService) ObjectFactory.getBean("ShoppingCartService");

    /**
     * Constructor of the object.
     */
    public ShoppingCartServlet() {
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


        String json = "[";

        ResJson rejson = shoppingCartService.selectShoppingCartAll(null);


        List<ShoppingCart> shoppingCartsList = rejson.getList();


        for (int i = 0; i < shoppingCartsList.size(); i++) {
            ShoppingCart shoppingCart = shoppingCartsList.get(i);
//					购物车ID
            json += "{\"id\":\"" + shoppingCart.getId() + "\"," +
//					用户ID
                    "\"userid \":\"" + shoppingCart.getUserName() + "\"," +
//					商品图片
                    "\"img \":\"" + shoppingCart.getImg() + "\"" +
//					数量
                    ",\"quantity \":\"" + shoppingCart.getQuantity() + "\"" +
//					销量
//					",\"pric \":\""+shoppingCart.getSalesVolume()+"\"" +
//					库存
//					",\"inStock\":\""+shoppingCart.getInStock()+"\"" +
//					厂家
//					",\"factory\":\""+shoppingCart.getFactory()+"\"" +
//					店家;
//					",\"store\":\""+shoppingCart.getStore()+"\"" +
//					保质期
//					",\"shelflife\":\""+shoppingCart.getShelflife()+"\"" +
//					状态
//					",\"situation\":\""+shoppingCart.getSituation()+"\"" +
//					创建时间
//					",\"createTime\":\""+shoppingCart.getCreateTime()+"\"" +
//					折扣
//					",\"Discount\":\""+goods.getDiscount()+"\"" +
//					价格
                    ",\"pric \":\"" + shoppingCart.getPrice() + "\"" +
//					小计
                    ",\"totalPric \":\"" + shoppingCart.getTotalPrice() + "\"" +
//					时间
                    ",\"creatime \":\"" + shoppingCart.getTimes() + "\"},";
        }

        json = json.substring(0, json.length() - 1) + "]";

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
        // Put your code here
    }

}
