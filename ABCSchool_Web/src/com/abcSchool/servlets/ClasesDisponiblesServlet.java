package com.abcSchool.servlets;

import java.io.IOException;

public class ClasesDisponiblesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ClaseDTO> clases=BusinessDelegate.getInstancia().verClasesDisponibles();
		request.setAttribute("clases",clases);
		String jsp="/ClasesDisponibles.jsp"; //revisar nombre jsp
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
	}
}
