package com.liao.servlet.add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.entity.Category;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.CategoryService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class AddCatrgoryServlet extends HttpServlet {
    CategoryService categoryService = (CategoryService) ObjectFactory.getBean("CategoryService");

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
//		获取id
        String id = request.getParameter("id");
//		获取类别名称
        String name = request.getParameter("name");
        Category c = new Category();
//		id
        c.setId(id);
//		名称
        c.setCategory(name);

        String json = "";
        ResJson resJson = categoryService.addCategory(c);

        if (resJson.getSub()) {

            json = "{\"isSuccess\":\"true\",\"user\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        } else {
//			失败
            json = "{\"isSuccess\":\"false\",\"user\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        }

        out.print(json);
        out.flush();
        out.close();
    }

}
