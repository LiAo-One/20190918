package com.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.entity.Category;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.UserService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
public class UserSelectServlet extends HttpServlet {
    static UserService userService =
            (UserService) ObjectFactory.getBean("UserService");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));

        int count = userService.selectUserCouny(null);

        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        ResJson rejson = userService.selectUserByLimit(pageNum, pageSize, null);


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
//					",\"name\":\""+user.getCategory()+"\"" +
//					创建时间;
                    ",\"createTime\":\"" + user.getCreateTime() + "\"},";
        }

        json = json.substring(0, json.length() - 1) + "]}";

        out.print(json);
        out.flush();
        out.close();
    }

}
