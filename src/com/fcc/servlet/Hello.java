package com.fcc.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 11:38 2018/12/3
 */
public class Hello extends HttpServlet {
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        System.out.println("cc");
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //HttpServlet的方法 start
        ServletConfig servletConfig = this.getServletConfig();
        String servletInfo = this.getServletInfo();

        System.out.println(this.getInitParameterNames());
        System.out.println(this.getServletContext().getInitParameter("encoding"));
        ServletContext servletContext = this.getServletContext();
        String servletName = this.getServletName();
        //HttpServlet的方法 end

        //HttpServletRequest对象获取客户端请求信息 start
        String requestUrl = request.getRequestURL().toString();//得到请求的URL地址
        String requestUri = request.getRequestURI();//得到请求的资源
        String queryString = request.getQueryString();//得到请求的URL地址中附带的参数
        String remoteAddr = request.getRemoteAddr();//得到来访者的IP地址
        String remoteHost = request.getRemoteHost();//得到来访者的完整主机名
        int remotePort = request.getRemotePort();//得到来访者的所使用的网络端口号
        String remoteUser = request.getRemoteUser();
        String method = request.getMethod();//得到请求URL地址时使用的方法
        String pathInfo = request.getPathInfo();//请求URL中的额外路径信息。额外路径信息是请求URL中的位于Servlet的路径之后和查询参数之前的内容，它以“/”开头。
        String localAddr = request.getLocalAddr();//获取WEB服务器的IP地址
        String localName = request.getLocalName();//获取WEB服务器的主机名

        String userName = request.getParameter("userName");//获取字段
        String[] roles = request.getParameterValues("roles");//获取数组
        request.getParameterNames();
        Map<String, String[]> map = request.getParameterMap();
        //HttpServletRequest对象获取客户端请求信息 end

        //获取cookie
        Cookie[] cookies = request.getCookies(); //获取cookie数组
        for(Cookie cookie:cookies){//遍历cookie数组
            System.out.println(cookie.getName());//获取cookie的名字
            System.out.println(cookie.getValue()); //获取cookie的值
        }
        //操作cookie
        Cookie cookie = new Cookie("name","value");
        cookie.setMaxAge(3600*24*3);//设置其生命周期
        response.addCookie(cookie);
        HttpSession session = request.getSession();
        session.setAttribute("name","cc");
        session.getServletContext();


        //设置服务器接收数据的编码格式，如果传输过来的数据不是utf-8则乱码
        request.setCharacterEncoding("UTF-8");
        //设置服务器响应内容的编码格式为UTF-8
        response.setCharacterEncoding("UTF-8");
        //设置服务器响应内容类型为text/html
        response.setContentType("text/html");
        //设置响应头,控制浏览器必须以UTF-8的编码解析数据，否则浏览器显示的将是乱码
        response.setHeader("content-type", "text/html;charset=UTF-8");
        // 输出文本
        PrintWriter out = response.getWriter();
        out.write("hello world");
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }


}
