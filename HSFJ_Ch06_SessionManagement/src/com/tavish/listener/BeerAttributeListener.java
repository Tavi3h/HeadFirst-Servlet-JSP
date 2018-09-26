package com.tavish.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

// 每一次向会话增加、删除、替换属性时都能跟踪到。
@WebListener
public class BeerAttributeListener implements HttpSessionAttributeListener {

    public BeerAttributeListener() {
    	
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	String name = se.getName();
    	Object value = se.getValue();
    	System.out.println("Attribute added: " + name + ": " + value);
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	String name = se.getName();
    	Object value = se.getValue();
    	System.out.println("Attribute removed: " + name + ": " + value);
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	String name = se.getName();
    	Object value = se.getValue();
    	System.out.println("Attribute replaced: " + name + ": " + value);
    }
	
}
