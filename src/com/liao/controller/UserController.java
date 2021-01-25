package com.liao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.UserService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
/**
 * 用户操作
 * @author soft01
 *
 */
public class UserController {
    private UserService userService = (UserService) ObjectFactory.getBean("UserService");

    /**
     * 用户注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void registered(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            System.out.println(user.toString() + "asd");

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

    /**
     * 用户分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectUserAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));

        User u = new User();
//		获取年龄
        u.setNikeName(request.getParameter("name"));
//		帐号
        u.setLoginName(request.getParameter("userName"));
//		年龄
        u.setAge(request.getParameter("age"));
//		等级
        u.setLev(request.getParameter("lev"));


        int count = userService.selectUserCouny(u);

        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        ResJson rejson = userService.selectUserByLimit(pageNum, pageSize, u);


        List<User> usersList = rejson.getList();

        for (int i = 0; i < usersList.size(); i++) {
            User user = usersList.get(i);

            json += "{\"id\":\"" + user.getId() + "\"" +
//					用户名
                    ",\"nikeName\":\"" + user.getNikeName() + "\"" +
//					用户密码
                    ",\"loginName\":\"" + user.getLoginName() + "\"" +
//					用户昵称
                    ",\"loginPwd\":\"" + user.getLoginPwd() + "\"" +
//					等级
                    ",\"lev\":\"" + user.getLev() + "\"" +
//					性别
                    ",\"sex\":\"" + user.getSex() + "\"" +
//					年龄
                    ",\"age\":\"" + user.getAge() + "\"" +
//					头像
                    ",\"img\":\"" + user.getImg() + "\"" +
                    // 余额
					",\"balance\":\""+user.getBalance()+"\"" +
//					创建时间;
                    ",\"createTime\":\"" + user.getCreateTime() + "\"},";
        }

        json = json.substring(0, json.length() - 1) + "]}";

        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * 用户添加
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void userAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

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
        ResJson resJson = userService.addUser(u);

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

    /**
     * 用户删除
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void userDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
//		获取ID
        String id = request.getParameter("id");
//		获取等级
        String lev = request.getParameter("lev");
        User u = new User();
//		ID
        u.setId(id);
//		等级
        u.setLev(lev);

        String json = "";
        ResJson resJson = userService.deleUser(u);

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

    /**
     * 用户修改
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void userModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
