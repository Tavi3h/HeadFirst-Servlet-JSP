package com.tavish.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Dog implements HttpSessionBindingListener {
	
	private String breed;
	
	public Dog(String breed) {
		this.breed = breed;
	}
	
	public String getBreed() {
		return breed;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// code to run now that I know I'm in a session
		System.out.println("I'm in a session " + getBreed());
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// code to run now that I know I am no longer part of a session
	}
}
