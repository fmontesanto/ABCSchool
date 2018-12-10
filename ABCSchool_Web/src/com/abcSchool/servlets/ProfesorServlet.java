package com.abcSchool.servlets;

import java.io.IOException;

public class ProfesorServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String dniProfesor = request.getParameter("dniProfesor");
			ProfesorDTO profesor=BusinessDelegate.getInstancia().buscarProfesor(dniProfesor); //REVISAR la llamada al bd
			request.setAttribute("profesor",profesor);
			String jsp="/Profesor.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
	        rd.forward(request, response);
		}
}
