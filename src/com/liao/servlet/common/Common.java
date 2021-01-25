package com.liao.servlet.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.entity.Category;
import com.liao.factory.ObjectFactory;
import com.liao.service.CategoryService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class Common extends HttpServlet {
    private CategoryService categoryService =
            (CategoryService) ObjectFactory.getBean("CategoryService");

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

//		int count = categoryService.selectCategoryCouny(null);

//		String json = "{\"total\":\""+count+"\",\"rows\":[";

        String json = "[";

        ResJson rejson = categoryService.selectCategoryAll();


        List<Category> categoryList = rejson.getList();

        for (int i = 0; i < categoryList.size(); i++) {
            Category cate = categoryList.get(i);

            json += "{\"id\":\"" + cate.getId() + "\",\"name\":\"" + cate.getCategory() + "\",\"time\":\"" + cate.getCreateTime() + "\"},";
        }

//		json = json.substring(0, json.length()-1) + "]}";
        json = json.substring(0, json.length() - 1) + "]";

        out.print(json);


        out.flush();
        out.close();
    }

}
