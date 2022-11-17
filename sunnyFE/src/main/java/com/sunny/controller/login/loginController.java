package com.sunny.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

@WebServlet(urlPatterns = {"/account/login"})
public class loginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login/login.jsp");
			dispatcher.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		JSONObject obj = new JSONObject(req.getParameter("userId"));
		
		session.setAttribute("user", obj);
		session.setAttribute("userId", obj.get("userId"));

		session.setAttribute("accountName", obj.get("accountName"));
		session.setAttribute("role", obj.getJSONObject("roleId").get("roleId"));
		
		if (req.getParameter("cus") != null)
		{
			JSONObject cus = new JSONObject(req.getParameter("cus")); 
			session.setAttribute("cus", cus);
			session.setAttribute("CusName", cus.get("name"));
		}
		
		
		
		
		
		//System.out.println( ((JSONObject) session.getAttribute("user")).get("accountName"));
		
	}
}
