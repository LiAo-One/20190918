package com.liao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.entity.Category;
import com.liao.factory.ObjectFactory;
import com.liao.service.CategoryService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
/**
 * 商品类别操作
 * @author soft01
 *
 */
public class CategoryController {

    private CategoryService categoryService = (CategoryService) ObjectFactory.getBean("CategoryService");

    /**
     * 商品类别添加
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void categoryAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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


    /**
     * 类别删除
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void categoryDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

//		获取id
        String id = request.getParameter("id");
        Category c = new Category();
//		获取类别名称
        c.setId(id);
//		名称

        String json = "";
        ResJson resJson = categoryService.deleCategory(c);

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

    /**
     * 类别修改
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void categoryModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        ResJson resJson = categoryService.modiCategory(c);

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


    /**
     * 类别分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void categorySelectPaginaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));

        Category c = new Category();
        c.setCategory(request.getParameter("name"));

        int count = categoryService.selectCategoryCouny(c);

        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        ResJson rejson = categoryService.selectCategoryByLimit(pageNum, pageSize, c);

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

    /**
     * 所有类别查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void categorySelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
