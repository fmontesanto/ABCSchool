package com.abcSchool.servlets;

import java.io.IOException;

public class CalendarioProfesorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dniProfesor = request.getParameter("dniProfesor");
		ArrayList<ClaseDTO> clases=BusinessDelegate.getInstancia().obtenerClaseProfesor(dniProfesor);
		request.setAttribute("clases",clases);
		String jsp="/CalendarioProfesor.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
	}
}

