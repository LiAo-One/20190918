package com.liao.servlet.delete;

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
public class GoodsDeleteServlet extends HttpServlet {


    GoodsService goodsService = (GoodsService) ObjectFactory.getBean("GoodsService");

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

        Goods g = new Goods();
//		获取ID
        g.setId(id);

        String json = "";
        ResJson resJson = goodsService.deleGoods(g);

        if (resJson.getSub()) {
//			获取当前登录的用户

            json = "{\"isSuccess\":\"true\",\"goods\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        } else {
//			失败
            json = "{\"isSuccess\":\"false\",\"goods\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        }


        out.print(json);
        out.flush();
        out.close();
    }

}
