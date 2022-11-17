package com.sunny.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet(urlPatterns = {"/account/getsession"})
public class GetSession extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONObject json = new JSONObject();
		Enumeration<String> attributes = req.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
		    String attribute = (String) attributes.nextElement();
		    //System.out.println(attribute+" : "+req.getSession().getAttribute(attribute));
		    json.put(attribute, req.getSession().getAttribute(attribute));
		}
		
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();   
	}
}
