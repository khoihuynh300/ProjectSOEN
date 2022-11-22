package com.sunny.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns =  {"/account/signup", "/account/signup/verify", "/account/signup/userinfo"})
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("/account/signup/verify")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login/verify.jsp");
			dispatcher.forward(req, resp);
		}
		else if(url.contains("/account/signup/userinfo")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login/userinfo.jsp");
			dispatcher.forward(req, resp);
		}
		
		else if(url.contains("/account/signup")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login/signup.jsp");
			dispatcher.forward(req, resp);
		}
		
	}

}
