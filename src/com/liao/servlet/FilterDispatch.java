package com.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liao.config.Configuration;
import com.liao.util.ControllerMapping;

@SuppressWarnings("all")
public class FilterDispatch extends HttpServlet {

    // mvc.xml 文件 读取出的 对象 集合
    private Map<String, ControllerMapping> controllMap = new HashMap<String, ControllerMapping>();


    // 存放 mvc.xml中 全类名  newInstance之后的类对象
    private Map<String, Object> objMap = new HashMap<String, Object>();


    /**
     * 核心控制器初始化事件
     */
    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();

        Configuration configuration = new Configuration();
        // 调用 读取配置文件 方法
        controllMap = configuration.getControllerMapping();


    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // 获取请求地址 /20190905/login.action
        String uri = request.getRequestURI();
        System.out.println("URL:" + uri);

        // 获取项目名
        String contextPath = request.getContextPath();

        // System.out.println(contextPath); // /20190905

        // 获取 /login
        String path = uri.substring(contextPath.length(), uri.indexOf(".action"));

         System.out.println(path);

        // 根据path 在对象中 找到 此path对应的method以及所在类

        ControllerMapping mapping = controllMap.get(path);
        

        // 取出对象中的 class
        String className = mapping.getClassName();

        // 取出对象中的method
        String method = mapping.getMethod();


        // 获取当前类的字节码文件对象
        Class clazz = null;

        Object obj = null;
        try {

            // 获取当前类的字节码文件对象
            clazz = Class.forName(className);
            if (!objMap.containsKey(className)) {

                // 说明在 对象集合中 不存在 该全类名 对应的 类对象

                // 根据字节码文件对象 获取 当前类对象
                obj = clazz.newInstance();
                // 将创建的对象存进集合
                objMap.put(className, obj);
            } else {
                obj = objMap.get(className);
            }

            // 根据字节码文件对象  以及 方法名  找到对应的方法
            Method m = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            // 调用方法
            m.invoke(obj, request, response);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e);
        }

    }

}
