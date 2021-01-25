package com.liao.servlet.modify;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.UserService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class UserServlet extends HttpServlet {
    UserService userService = (UserService) ObjectFactory.getBean("UserService");

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
//		获取姓名
        String name = request.getParameter("name");
//		获取帐号
        String account = request.getParameter("account");
//		获取密码
        String pwd = request.getParameter("pwd");
//		获取性别
        String sex = request.getParameter("sex");
//		获取年龄
        String age = request.getParameter("age");
//		获取等级
        String lev = request.getParameter("lev");
//		获取头像
        String img = request.getParameter("img");

        User u = new User();
//		ID
        u.setId(id);
//		姓名
        u.setNikeName(name);
//		帐号
        u.setLoginName(account);
//		密码
        u.setLoginPwd(pwd);
//		性别
        u.setSex(sex);
//		年龄
        u.setAge(age);
//		等级
        u.setLev(lev);
//		头像
        u.setImg(img);
        String json = "";
        ResJson resJson = userService.modiUser(u);

        if (resJson.getSub()) {
//			获取当前登录的用户

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
