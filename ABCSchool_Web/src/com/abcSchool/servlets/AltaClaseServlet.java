package com.abcSchool.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AltaClaseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String materia = request.getParameter("materia");
		String fecha = request.getParameter("fecha"); // pasar a sql date
		String horario = request.getParameter("horario"); //pasar a float
		String estado = request.getParameter("estado");
		String dniProf=request.getParameter("dni");
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date utilDate_FechaClase= df.parse(fecha);
		java.sql.Date sqlDate_fechaClase=new java.sql.Date(utilDate_FechaClase.getTime());
		Float horarioFloat=Float.valueOf(horario);
		
		String jspPage;
			//chequear como llamar bien al bd.
		BusinesDelegate.getInstancia().altaClase(materia,sqlDate_fechaClase,horarioFloat, estado,dniProf);
		jspPage="/DatosCorrectos.jsp"; /// CAMBIAR JSP CON EL QUE VA
		RequestDispatcher rd = request.getRequestDispatcher(jspPage);
        rd.forward(request, response);
	}
}
