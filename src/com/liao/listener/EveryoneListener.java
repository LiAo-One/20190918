package com.liao.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class EveryoneListener implements HttpSessionListener {


    /**
     * session 被创建时调用
     * <p>
     * 总人数 ++
     */
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        /*System.out.println("asdaaaaaaaaaa");
        // 获取全局作用域对象
        ServletContext context = sessionEvent.getSession().getServletContext();
        //存储总人数
        int num = 0;
        //输入流
        BufferedReader buff = null;
        //输入流
        try {
            buff = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("Everyone.txt")));
            //存储读取的文本
            String str = "";
            while ((str = buff.readLine()) != null) {
                //转为int
                num = Integer.parseInt(str);
                //存入全局域
                context.setAttribute("Every", ++num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (buff != null) {
                try {
                    buff.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

    }

    /**
     * session 被销毁时调用
     * <p>
     * 保存
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        System.out.println("asdaaaaaaaaaa");
        // 获取全局作用域对象
        ServletContext context = sessionEvent.getSession().getServletContext();

        // 从全局作用域对象中 获取在线人数
        int num = (Integer) context.getAttribute("Every");

//		输出流
        BufferedWriter buffw = null;
        try {
            buffw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("Everyone.txt")));

            buffw.write(num + "".toString());
//			写入数据
            buffw.newLine();
//			刷新输出流
            buffw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (buffw != null) {
                try {
                    buffw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
