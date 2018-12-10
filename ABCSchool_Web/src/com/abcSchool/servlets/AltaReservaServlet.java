package com.abcSchool.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AltaReservaServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descuento = request.getParameter("descuento"); //pasar a float
		String domicilio = request.getParameter("domicilio");
		String monto=request.getParameter("monto"); //pasar a float
		String cantAlumnos = request.getParameter("cantAlumnos");
		String fechaActual = request.getParameter("fechaActual");
		String dniAlumno=request.getParameter("dniAlumno");
		//Ver tema del array de ID de Clases... se puede recibir un array como parametro?
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date utilDate_FechaActual= df.parse(fechaActual);
		java.sql.Date sqlDate_fechaActual=new java.sql.Date(utilDate_FechaActual.getTime());
		boolean paga=true;
		String jsp;
			//chequear como llamar bien al bd.
			BusinessDelegate.getInstancia().altaReserva(0 /*idReserva*/,  Float.valueOf(descuento), Float.valueOf(monto),Integer.valueOf(cantAlumnos), paga, sqlDate_fechaActual, dniAlumno, ArrayList<String> clases);
			 jsp="/ReservaCorrecta.jsp"; //Cambiar por el nombre del jsp que va
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
	}

}
