package edu.tavish.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class BeerRequestFilter implements Filter {

	private FilterConfig fc;

	/*
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 * 必须实现init()，通常只需要保存配置（config）对象
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fc = fConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String name = req.getRemoteUser();
		if (name != null) {
			fc.getServletContext().log("user " + name + " is updating");
		}
		chain.doFilter(request, response);
	}

	/*
	 * @see javax.servlet.Filter#destroy() 必须实现destroy()方法，通常这个方法为空
	 */
	public void destroy() {

	}
}
