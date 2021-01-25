package com.liao.servlet.modify;

import java.io.IOException;
import java.io.PrintWriter;

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

//		获取ID
        String id = request.getParameter("id");
//		获取数量
        String quantity = request.getParameter("quantity");
//		获取小计
        String totalPrice = request.getParameter("totalPrice");

        ShoppingCart shopping = new ShoppingCart();
//		id
        shopping.setId(id);
//		数量
        shopping.setQuantity(quantity);
//		小计
        shopping.setTotalPrice(totalPrice);

        String json = "";
        ResJson rejson = shoppingCartService.modiShoppingCartQuantity(shopping);


        if (rejson.getSub()) {
//			获取当前登录的用户

            json = "{\"isSuccess\":\"true\",\"user\":\"" + null + "\",\"message\":\"" + rejson.getStr() + "\"}";
        } else {
//			失败
            json = "{\"isSuccess\":\"false\",\"user\":\"" + null + "\",\"message\":\"" + rejson.getStr() + "\"}";
        }

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
