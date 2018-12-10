package com.abcSchool.servlets;

import java.io.IOException;

public class PerfilAlumnoServlet extends HttpServlet {

		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String dniAlumno = request.getParameter("dniAlumno");
			AlumnoDTO alumno=BusinessDelegate.getInstancia().buscarAlumno(dniAlumno); //REVISAR la llamada al bd
			ArrayList<ReservaDTO> reservas=BusinessDelegate.getInstancia().obtenerReservasAlumno(dniAlumno);
			request.setAttribute("alumno",alumno);
			request.setAttribute("reservas",reservas);
			String jsp="/PerfilAlumno.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
	        rd.forward(request, response);
		}
}