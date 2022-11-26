package com.sunny.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/account/forget", "/account/forget/resetpw"})
public class forgetPasswordController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("/account/forget/resetpw")) {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login/resetpassword.jsp");
			dispatcher.forward(req, resp);
		}
		else if(url.contains("/account/forget")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login/forgetpassword.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
