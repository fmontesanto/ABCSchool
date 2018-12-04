package com.abcSchool.servlets;

import java.io.IOException;
import java.util.List;

import javax.naming.CommunicationException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import del BusinessDelegate;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usr = request.getParameter("usr");
		String clave = request.getParameter("clave");
		String rol = request.getParameter("rol");

		try {
			if(usr.equals("alum")) {
				
			} else if(usr.equals("prof")) {
				
			} else if(usr.equals("admin")){
				
			}
		} catch (CommunicationException e) {
			e.printStackTrace();
		}
	}

}
