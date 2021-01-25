package com.liao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {


    /**
     * 全局对象创建
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("Application创建");

    }

    /**
     * 全局对象销毁
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("Application销毁");

    }

}
