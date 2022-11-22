package com.sunny.controller.shipper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/shipper", "/shipper/nhan-don", "/shipper/chua-giao", "/shipper/da-giao"})
public class HomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("/shipper/nhan-don")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/shipper/nhandon.jsp");
			dispatcher.forward(req, resp);
		}
		else if(url.contains("/shipper/chua-giao")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/shipper/chuagiao.jsp");
			dispatcher.forward(req, resp);
		}
		
		else if(url.contains("/shipper/da-giao")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/shipper/dagiao.jsp");
			dispatcher.forward(req, resp);
		}
		else if(url.contains("/shipper")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/shipper/home.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
