package com.liao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liao.entity.Address;
import com.liao.entity.Comment;
import com.liao.entity.Goods;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.CommentService;
import com.liao.service.UserService;
import com.liao.util.ResJson;

@SuppressWarnings("all")
/**
 * 评论操作
 *
 * @author soft01
 *
 */
public class CommonController {

    private CommentService commService = (CommentService) ObjectFactory.getBean("CommentService");

    private UserService userService = (UserService) ObjectFactory.getBean("UserService");
    /**
     * 评论查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void CommentSelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String goodsId = request.getParameter("goodsId");
        Goods g = new Goods();
        g.setId(goodsId);
        // 分页查询参数
        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));

        // 获取查询参数
        Comment comment = new Comment();
        // 用户ID
        comment.setUserid(request.getParameter("userId"));
        // 用户姓名
        comment.setUserName(request.getParameter("userName"));
        // 用户地址
        comment.setGoodsName(request.getParameter("goodsName"));
        // 手机
        comment.setMood(request.getParameter("mood"));

        int count = commService.selectCommentouny(comment, null);

        String json = "{\"total\":\"" + count + "\",\"rows\":[";

        ResJson rejson = commService.selectCommentByLimit(pageNum, pageSize,comment,null);

        List<Comment> commentList = rejson.getList();

        for (int i = 0; i < commentList.size(); i++) {
            Comment comm = commentList.get(i);
            // 评论ID
            json += "{\"id\":\"" + comm.getId() + "\"," +
                    // 用户ID
                    "\"userId\":\"" + comm.getUserid() + "\"," +
                    // 用户姓名
                    "\"userName\":\"" + comm.getUserName() + "\"" +
                    // 用户头像
                    ",\"userImg\":\"" + comm.getUserImg() + "\"" +
                    // 商品ID
                    ",\"goodsid\":\"" + comm.getGoodsid() + "\"" +
                    // 商品名称
                    ",\"goodsName\":\"" + comm.getGoodsName() + "\"" +
                    // 满意度
                    ",\"mood\":\"" + comm.getMood() + "\"" +
                    // 语句;
                    ",\"fell\":\"" + comm.getFell() + "\"" +
                    // 状态
                    ",\"situation\":\"" + comm.getSituation() + "\"" +
                    // 时间
                    ",\"times\":\"" + comment.getTimes() + "\"},";
        }
        json = json.substring(0, json.length() - 1) + "]}";
        out.print(json);
        out.flush();
        out.close();
    }
    
    /**
     * 根据商品ID查询评论
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void goodsIdComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ResJson rejson = null;
        // 获取查询参数
        Comment comment = new Comment();
        // 商品ID
        comment.setGoodsid(request.getParameter("goodsId"));

        rejson = commService.selectGoodsCommentouny(comment, null);

        String json = "{\"total\":\"" + rejson.getList().size() + "\",\"rows\":[";

//        rejson = commService.selectGoodsCommentouny(comment, null);

        List<Comment> commentList = rejson.getList();

        for (int i = 0; i < commentList.size(); i++) {
            Comment comm = commentList.get(i);
            // 评论ID
            json += "{\"id\":\"" + comm.getId() + "\"," +
                    // 用户ID
                    "\"userId\":\"" + comm.getUserid() + "\"," +
                    // 用户姓名
                    "\"userName\":\"" + comm.getUserName() + "\"" +
                    // 用户头像
                    ",\"userImg\":\"" + comm.getUserImg() + "\"" +
                    // 商品ID
                    ",\"goodsid\":\"" + comm.getGoodsid() + "\"" +
                    // 商品名称
                    ",\"goodsName\":\"" + comm.getGoodsName() + "\"" +
                    // 满意度
                    ",\"mood\":\"" + comm.getMood() + "\"" +
                    // 语句;
                    ",\"fell\":\"" + comm.getFell() + "\"" +
                    // 状态
                    ",\"situation\":\"" + comm.getSituation() + "\"" +
                    // 时间
                    ",\"times\":\"" + comment.getTimes() + "\"},";
        }
        json = json.substring(0, json.length() - 1) + "]}";
        out.print(json);
        out.flush();
        out.close();
    }
    
    /**
     * 评论添加
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addGoodsCommon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取商品ID
        String goodsId = request.getParameter("goodsId");
        // 获取评论语句
        String fell = request.getParameter("feel");
        // 获取当前登录的用户
        HttpSession s = request.getSession();

        User u = (User) s.getAttribute("user");
        
        Comment comment = new Comment();
        // 用户ID
        comment.setUserid(u.getId());
        // 商品ID
        comment.setGoodsid(goodsId);
        // 评论语句
        comment.setFell(fell);
        String json = "";

        ResJson resJson = commService.addComment(comment, null);
        if (resJson.getSub()) {
//			成功
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
