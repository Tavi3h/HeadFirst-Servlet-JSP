package com.tavish.initparam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(urlPatterns = { "/InitParamServlet" }, initParams = {
		// 设置初始化参数
		@WebInitParam(name = "adminEmail", value = "likewecare@wickedlysmart"),
		@WebInitParam(name = "mainEmail", value = "blooper@wickedlysmart.com") })
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("test init parameters<br>");
		
		// 获取Servlet初始化参数
		Enumeration<String> e = getServletConfig().getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			out.println("<br>param name = " + name + " ,param value = " + getServletConfig().getInitParameter(name));
		}
		
		// 获取上下文初始化参数
		out.println("<br>");
		out.println(getServletContext().getInitParameter("adminEmail"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
