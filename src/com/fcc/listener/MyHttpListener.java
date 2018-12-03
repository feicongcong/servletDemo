package com.fcc.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 15:28 2018/12/3
 */
public class MyHttpListener implements HttpSessionListener,HttpSessionActivationListener {
    //HttpSessionListener监听http会话创建和销毁
    /* Session创建事件 */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        ServletContext ctx = event.getSession().getServletContext();
        Integer numSessions = (Integer) ctx.getAttribute("numSessions");
        if (numSessions == null) {
            numSessions = new Integer(1);
        } else {
            int count = numSessions.intValue();
            numSessions = new Integer(count + 1);
        }
        System.out.println(numSessions);
        ctx.setAttribute("numSessions", numSessions);
    }

    /* Session失效事件 */
    //session是有一个超时时间的，浏览器关闭其实对于web服务器来说是不知道的，所以他需要等待超时时间到了之后自动销毁
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer numSessions = (Integer) ctx.getAttribute("numSessions");
        if (numSessions == null) {
            numSessions = new Integer(0);
        } else {
            int count = numSessions.intValue();
            numSessions = new Integer(count - 1);
        }
        System.out.println(numSessions);
        ctx.setAttribute("numSessions", numSessions);
    }

    //HttpSessionActivationListener监听http会话持久化 https://blog.csdn.net/feicongcong/article/details/84769879
}
