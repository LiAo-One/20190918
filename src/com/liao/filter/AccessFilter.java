package com.liao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccessFilter implements Filter {

    /**
     * 销毁时执行
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    /**
     * 处理过滤时执行
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // 将ServletRequest转成HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;

        // 将ServletResponse转成HttpServletResponse
        HttpServletResponse response = (HttpServletResponse) resp;


        // 判断用户是否登录
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {


            // 获取请求地址：request.getRequestURL()); // http://10.0.4.147/20190918/manager/userSelectServlet.action
//			String url = request.getRequestURL().toString(); // http://10.0.4.98/20190918/jsp/login.jsp

            String uri = request.getRequestURI().toString(); // /20190918/jsp/login.jsp

//			String urlIP = url.substring(0, url.indexOf("manager"));
            String uriIP = uri.substring(0, uri.indexOf("manager"));

//			System.out.println(urlIP);
//			System.out.println(uriIP);

            // 说明用户没有登录，页面跳转进登录页
            response.sendRedirect(uriIP + "jsp/login.jsp");

        } else {
            // 放行
            chain.doFilter(req, resp);
        }

    }

    /**
     * 初始化时执行
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
