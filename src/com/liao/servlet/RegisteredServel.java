package com.liao.servlet;

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
public class RegisteredServel extends HttpServlet {
    static UserService userService =
            (UserService) ObjectFactory.getBean("UserService");

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

        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");

        User u = new User();

        u.setLoginName(loginName);
        u.setLoginPwd(loginPwd);

        String json = "";

        UserService userService = (UserService) ObjectFactory.getBean("UserService");

        ResJson resJson = userService.addUser(u);
        if (resJson.getSub()) {
//			获取当前注册的用户
//			User user = (User)resJson.getList().get(0);
//			注册成功
            json = "{\"isSuccess\":\"true\",\"user\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        } else {
//			失败
            json = "{\"isSuccess\":\"false\",\"user\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
            System.out.println(resJson.getStr());
        }

        out.print(json);
        out.flush();
        out.close();
    }

}
