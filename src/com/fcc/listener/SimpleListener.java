package com.fcc.listener;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//被 @WebListener 标注的类必须实现以下至少一个接口：
//ServletContextListener
//ServletContextAttributeListener
//ServletRequestListener
//ServletRequestAttributeListener
//HttpSessionListener
//HttpSessionAttributeListener
@WebListener("This is only a demo listener")
public class SimpleListener implements ServletContextListener {
}