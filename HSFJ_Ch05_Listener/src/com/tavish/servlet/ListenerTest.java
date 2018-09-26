package com.tavish.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tavish.model.Dog;

/**
 * Servlet implementation class ListenerTest
 */
@WebServlet("/ListenerTest")
public class ListenerTest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("test context attributes set by listener<br>");
		pw.println("<br>");
		Dog dog = (Dog) getServletContext().getAttribute("dog");
		pw.println("Dog's breed is " + dog.getBreed());
		Dog dog2 = new Dog("Bufflo");
		Dog dog3 = new Dog("Bull");
		request.getSession(true).setAttribute("dog", dog2);
		request.getSession(true).setAttribute("dog", dog3);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
