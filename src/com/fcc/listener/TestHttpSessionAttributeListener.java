package com.fcc.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Enumeration;

public class TestHttpSessionAttributeListener implements
        HttpSessionAttributeListener {
 
	// 当有对象加入session范围时触发，session.setAttribute("name","cc");
    @Override
	public void attributeAdded(HttpSessionBindingEvent se) {
        //HttpSessionBindingEvent的主要方法：getName(),getSession(),getValues()
        se.getSession().getAttributeNames();
        Enumeration<String> enums =se.getSession().getServletContext().getAttributeNames();
        System.out.println(enums);

	}
 
	// 当有对象从session范围移除时触发
    @Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out
				.println("TestHttpSessionAttributeListener-->>>attributeRemoved()");
	}
 
	// 当有对象从session范围代替时触发
    @Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out
				.println("TestHttpSessionAttributeListener-->>>attributeReplaced()");
	}
 
}
