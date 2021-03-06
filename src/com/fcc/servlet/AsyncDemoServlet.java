package com.fcc.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//servlet3.0介绍https://www.ibm.com/developerworks/cn/java/j-lo-servlet30/index.html
//servlet配成异步，跟其相关的filter也要配成异步
@WebServlet(urlPatterns = "/async", asyncSupported = true,name="async",loadOnStartup = -1,
initParams = {},displayName = "",description = "")
public class AsyncDemoServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("进入Servlet的时间：" + new Date() + ".");
        out.flush();

        //在子线程中执行业务调用，并由其负责输出响应，主线程退出
        //req.startAsync()利用原有的请求与响应对象来创建异步上下文AsyncContext
        AsyncContext ctx = req.startAsync();
        new Thread(new Executor(ctx)).start();

        out.println("结束Servlet的时间：" + new Date() + ".");
        out.flush();
    }
}

class Executor implements Runnable {
    private AsyncContext ctx = null;

    public Executor(AsyncContext ctx) {
        this.ctx = ctx;
    }
    @Override
    public void run() {
        try {
            //等待十秒钟，以模拟业务方法的执行
            Thread.sleep(10000);
            PrintWriter out = ctx.getResponse().getWriter();
            out.println("业务处理完毕的时间：" + new Date() + ".");
            out.flush();
            ctx.complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}