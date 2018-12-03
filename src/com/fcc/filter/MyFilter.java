package com.fcc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 14:31 2018/12/3
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //FilterConfig由servlet容器实现，主要用于获取过滤器中的配置信息
        filterConfig.getFilterName();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置服务器接收数据的编码格式，如果传输过来的数据不是utf-8则乱码
        servletRequest.setCharacterEncoding("UTF-8");
        //设置服务器响应内容的编码格式为UTF-8
        servletRequest.setCharacterEncoding("UTF-8");
        //设置服务器响应内容类型为text/html
        servletResponse.setContentType("text/html");
        //设置响应头,控制浏览器必须以UTF-8的编码解析数据，否则浏览器显示的将是乱码
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        response.setHeader("content-type", "text/html;charset=UTF-8");
        //FilterChain接口由servlet容器实现，是过滤器的传递工具对象
        //将请求传递给下一过滤器或目标资源
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
