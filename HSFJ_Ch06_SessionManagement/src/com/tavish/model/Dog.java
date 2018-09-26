package com.tavish.model;
import java.io.Serializable;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Dog implements HttpSessionBindingListener, HttpSessionActivationListener, Serializable {

	private static final long serialVersionUID = -3828421366549357135L;

	private String breed;
	// 假设这里还有更多实例变量，包括一些非Serializable的实例变量
	
	// 构造函数及其它set、get方法
	public String getBreed() {
		return breed;
	}
	
	// 会话激活事件
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// 这些代码用于恢复字段、取消在sessionWillPassivate()中做的动作
	}
	
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		// 这些代码将非Serializable字段置为某种状态，以便顺利地迁移到一个新VM
	}
	
	// 会话绑定事件
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// 我知道我再一个会话中时要运行的代码
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// 我知道自己已经不在一个会话中时要运行的代码
	}
}
