package com.liao.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("all")
public class UploadServlet extends HttpServlet {

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

}
