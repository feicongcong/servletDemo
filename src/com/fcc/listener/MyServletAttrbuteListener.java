package com.fcc.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @Description:
 * @Author: CC.F
 * @Date: 15:19 2018/12/3
 */
public class MyServletAttrbuteListener implements ServletContextAttributeListener {

    //当程序向application范围添加属性时触发该方法
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        ServletContext application = event.
                getServletContext();
        //获取添加的属性名和属性值
        String name = event.getName();
        Object value = event.getValue();
        System.out.println(application + "范围内添加了名为"
                + name + "，值为" + value + "的属性!");
    }

    //当程序从application范围删除属性时触发该方法
    @Override
    public void attributeRemoved
    (ServletContextAttributeEvent event) {
        ServletContext application = event.getServletContext();
        //获取被删除的属性名和属性值
        String name = event.getName();
        Object value = event.getValue();
        System.out.println(application + "范围内名为"
                + name + "，值为" + value + "的属性被删除了!");
    }

    //当application范围的属性被替换时触发该方法
    @Override
    public void attributeReplaced
    (ServletContextAttributeEvent event) {
        ServletContext application = event.getServletContext();
        //获取被替换的属性名和属性值
        String name = event.getName();
        Object value = event.getValue();
        System.out.println(application + "范围内名为"
                + name + "，值为" + value + "的属性被替换了!");
    }

}
