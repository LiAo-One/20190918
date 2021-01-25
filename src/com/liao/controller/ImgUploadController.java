package com.liao.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@SuppressWarnings("all")
/**
 * 图片上传操作类
 *
 * @author soft01
 */
public class ImgUploadController {

    /**
     * 商品图片上传
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void GoodsImgUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        // 定义文件名
        String fileName = "";

        try {
            // 创建基于本项目的 磁盘 工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // 设置缓冲区大小
            factory.setSizeThreshold(4096);

            // 创建一个文件上传处理程序
            ServletFileUpload upload = new ServletFileUpload(factory);

            // 设置请求文件大小
            upload.setFileSizeMax(4 * 1024 * 1024);

            // 获取请求中所有上传文件
            List<FileItem> items = upload.parseRequest(request);
            // 将 集合转成迭代器
            Iterator<FileItem> iterator = items.iterator();

            // 遍历
            while (iterator.hasNext()) {
                // 获取当前遍历到的上传文件
                FileItem file = iterator.next();

                // 获取当前文件的文件名
                fileName = file.getName();

                // 将文件上传到服务器中
                // 定义目标文件
                File fileUpload = new File(request.getSession().getServletContext().getRealPath("/") + "goodsimg/" + file.getName());

                // 将文件写入 目标路劲
                file.write(fileUpload);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.print("<script>top.window.showImg('" + fileName + "');</script>");
        out.flush();
        out.close();
    }


    /**
     * 商品图片上传
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void UserImgUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        // 定义文件名
        String fileName = "";

        try {
            // 创建基于本项目的 磁盘 工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // 设置缓冲区大小
            factory.setSizeThreshold(4096);

            // 创建一个文件上传处理程序
            ServletFileUpload upload = new ServletFileUpload(factory);

            // 设置请求文件大小
            upload.setFileSizeMax(4 * 1024 * 1024);

            // 获取请求中所有上传文件
            List<FileItem> items = upload.parseRequest(request);
            // 将 集合转成迭代器
            Iterator<FileItem> iterator = items.iterator();

            // 遍历
            while (iterator.hasNext()) {
                // 获取当前遍历到的上传文件
                FileItem file = iterator.next();

                // 获取当前文件的文件名
                fileName = file.getName();

                // 将文件上传到服务器中
                // 定义目标文件
                File fileUpload = new File(request.getSession().getServletContext().getRealPath("/") + "imgas/" + file.getName());
                // 将文件写入 目标路劲
                file.write(fileUpload);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.print("<script>top.window.showImg('" + fileName + "');</script>");
        out.flush();
        out.close();
    }
}
