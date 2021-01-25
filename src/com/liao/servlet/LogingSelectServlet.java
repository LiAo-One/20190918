package com.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.UserService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class LogingSelectServlet extends HttpServlet {

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
//		方式一
//		ServletContext sContext = this.getServletContext();
//		方式二
//		ServletContext sContext = this.getServletConfig().getServletContext();
//		方式三
        ServletContext sContext = request.getSession().getServletContext();
//		获取
//		int num = Integer.parseInt(sContext.getInitParameter("num"));

        if (sContext.getAttribute("num") == null) {
            sContext.setAttribute("num", 1);

        } else {
            int num = (Integer) sContext.getAttribute("num");
            num++;
            sContext.setAttribute("num", num);
        }

        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");
        User u = new User();

        u.setLoginName(loginName);
        u.setLoginPwd(loginPwd);

        String json = "";
        UserService userService = (UserService) ObjectFactory.getBean("UserService");
        ResJson resJson = userService.login(u);
        if (resJson.getSub()) {
//			获取当前登录的用户
            User user = (User) resJson.getList().get(0);
//			登录成功	
//			Cookie userName = new Cookie("userName","Mr.Wick");
//    		userName.setMaxAge(7*24*3600);
//    		response.addCookie(userName);

            HttpSession session = request.getSession();

            session.setAttribute("user", user);

            session.setMaxInactiveInterval(100000);

            json = "{\"isSuccess\":\"true\",\"user\":\"" + user + "\",\"message\":\"" + resJson.getStr() + "\"}";
        } else {
//			失败
            json = "{\"isSuccess\":\"false\",\"user\":\"" + null + "\",\"message\":\"" + resJson.getStr() + "\"}";
        }


        out.print(json);
        out.flush();
        out.close();
    }

}
