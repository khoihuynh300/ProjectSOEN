package com.sunny.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.model.User;

public class AuthorizationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("OK------------------------------------------------------------------------");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User model = (User) session.getAttribute("user");
		
		String admin = req.getRequestURL().substring(22, 27);
		String shipper = req.getRequestURL().substring(22, 29);
		if (model != null || true) {
			
			if ( /*(model.getRoleId().getRoleId() == 1 && admin.equals("admin") ) ||*/ true ) {
				System.err.println("admin");
				chain.doFilter(request, response);
			} else if (model.getRoleId().getRoleId() == 3 && shipper.equals("shipper")) {
				chain.doFilter(request, response);
			} else {
				
				resp.sendRedirect("/login");
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
