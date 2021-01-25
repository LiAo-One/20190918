package com.liao.servlet;

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
public class CategorySelectServlet extends HttpServlet {

    private CategoryService categoryService = (CategoryService) ObjectFactory.getBean("CategoryService");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));

        int count = categoryService.selectCategoryCouny(null);

        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        ResJson rejson = categoryService.selectCategoryByLimit(pageNum, pageSize, null);

        List<Category> categoryList = rejson.getList();

        for (int i = 0; i < categoryList.size(); i++) {
            Category cate = categoryList.get(i);

            json += "{\"id\":\"" + cate.getId() + "\",\"name\":\"" + cate.getCategory() + "\",\"time\":\"" + cate.getCreateTime() + "\"},";
        }

        json = json.substring(0, json.length() - 1) + "]}";

        out.print(json);
        out.flush();
        out.close();
    }

}
