package com.tavish.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// 这个监听者允许你跟踪这个Web应用中活动会话的个数。
@WebListener
public class BeerSessionCounter implements HttpSessionListener {

	private static int activeSessions;
	
    public BeerSessionCounter() {
    }
    
    public int getActiveSessions() {
    	return activeSessions;
    }

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		activeSessions++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		activeSessions--;
	}
}
