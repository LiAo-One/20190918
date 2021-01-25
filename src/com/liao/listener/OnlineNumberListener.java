package com.liao.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineNumberListener implements HttpSessionListener, ServletContextListener {


    /**
     * session 被创建时调用
     * <p>
     * 在线人数 ++
     */
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        // 获取全局作用域对象
        ServletContext context = sessionEvent.getSession().getServletContext();

        // 从全局作用域对象中 获取在线人数
        int num = (Integer) context.getAttribute("num");

        context.setAttribute("num", ++num);

    }

    /**
     * session 被销毁时调用
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        // 获取全局作用域对象
        ServletContext context = sessionEvent.getSession().getServletContext();

        // 从全局作用域对象中 获取在线人数
        int num = (Integer) context.getAttribute("num");

        context.setAttribute("num", --num);

    }

    /**
     * 全局作用域被销毁时调用
     * <p>
     * 服务器关闭时调用
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    /**
     * 全局作用域创建时被调用
     * <p>
     * 服务器启动时调用
     * <p>
     * 项目启动时 设置在线人数为0
     */
    @Override
    public void contextInitialized(ServletContextEvent eventContextEvent) {
        // 项目启动时 设置 在线人数

        // 获取全局作用域
        ServletContext context = eventContextEvent.getServletContext();

        // 将在线人数 set 进全局作用域
        context.setAttribute("num", 0);

    }

}
