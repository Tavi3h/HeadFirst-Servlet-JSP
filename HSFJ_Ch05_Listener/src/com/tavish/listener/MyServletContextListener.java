package com.tavish.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.tavish.model.Dog;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyServletContextListener() {
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	// 由事件得到ServletContext
    	ServletContext sc = sce.getServletContext();
    	// 使用上下文得到初始化参数
    	String dogBreed = sc.getInitParameter("breed");
    	// 创建Dog实例
    	Dog dog = new Dog(dogBreed);
    	// 使用上下文来设置属性
    	sc.setAttribute("dog", dog);
    	
    }
	
}
