package com.fcc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description: servlet上下文件监听器
 * @Author: CC.F
 * @Date: 15:03 2018/12/3
 */
public class MyContextListener implements ServletContextListener {
    //contextInitialized()监听servletContext的创建（web服务器启动）
    //contextDestroyed()监听servletContext的销毁（web服务器停止）
    // 也被称为web应用程序的生命周期方法
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("this is contextInitialized");
    }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("this is contextDestroyed");
    }

}
